package com.github.trembita.caching

import cats.{Id, Monad}
import cats.effect.Sync
import cats.effect.concurrent.Ref
import com.github.trembita.Environment
import cats.syntax.all._
import com.github.trembita.operations.{CanToVector, FromVector}

import scala.concurrent.duration.FiniteDuration
import scala.language.higherKinds

case class ExpirationTimeout(duration: FiniteDuration)

trait Caching[F[_], E <: Environment, A] {
  protected implicit def monad: Monad[F]
  protected def timeout: ExpirationTimeout

  protected def cacheRepr(cacheName: String, repr: E#Repr[A]): F[Unit]
  protected def getFromCache(cacheName: String): F[Option[E#Repr[A]]]

  def cached(cacheName: String, repr: => F[E#Repr[A]]): F[E#Repr[A]] = getFromCache(cacheName).flatMap {
    case Some(v) =>
      v.pure[F]

    case _ =>
      repr.flatTap { result =>
        cacheRepr(cacheName, result)
      }
  }

  def stop(): F[Unit]
}

object Caching {
  def localCaching[F[_], E <: Environment, A](
      expirationTimeout: ExpirationTimeout
  )(implicit F: Sync[F], toVector: CanToVector.Aux[E#Repr, Id], fromVector: FromVector[E#Repr]): F[Caching[F, E, A]] =
    Ref.of[F, Map[String, (Long, Vector[A])]](Map.empty).map { cacheRef =>
      new Caching[F, E, A] {
        protected implicit val monad: Monad[F]   = F
        protected val timeout: ExpirationTimeout = expirationTimeout

        def cacheRepr(cacheName: String, repr: E#Repr[A]): F[Unit] =
          cacheRef.update(_.updated(cacheName, System.currentTimeMillis() -> toVector(repr)))

        def getFromCache(cacheName: String): F[Option[E#Repr[A]]] =
          cacheRef
            .update { cache =>
              cache.get(cacheName) match {
                case Some((cachingTime, _)) if System.currentTimeMillis() - cachingTime >= expirationTimeout.duration.toMillis =>
                  cache - cacheName
                case _ => cache
              }
            }
            .flatMap(_ => cacheRef.get.map(_.get(cacheName).map { case (_, vs) => fromVector(vs) }))

        def stop(): F[Unit] = cacheRef.set(Map.empty)
      }
    }
}
