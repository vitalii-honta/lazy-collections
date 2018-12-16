package com.github.trembita.experimental.spark

import cats.{Monad, MonadError}
import com.github.trembita._

import scala.language.higherKinds
import scala.reflect.ClassTag
import scala.util.control.NonFatal

trait MagnetlessSparkBasicOps[F[_], A] extends Any {
  def `this`: DataPipelineT[F, A, Spark]

  def map[B: ClassTag](
    f: A => B
  )(implicit F: Monad[F]): DataPipelineT[F, B, Spark] =
    `this`.mapImpl(f)

  def flatMap[B: ClassTag](
    f: A => DataPipelineT[F, B, Spark]
  )(implicit F: Monad[F]): DataPipelineT[F, B, Spark] =
    `this`.flatMapImpl(f)

  def filter(p: A => Boolean)(implicit F: Monad[F],
                              A: ClassTag[A]): DataPipelineT[F, A, Spark] =
    `this`.filterImpl(p)

  def collect[B: ClassTag](
    pf: PartialFunction[A, B]
  )(implicit F: Monad[F]): DataPipelineT[F, B, Spark] =
    `this`.collectImpl(pf)

  def flatCollect[B: ClassTag](
    pf: PartialFunction[A, DataPipelineT[F, B, Spark]]
  )(implicit F: Monad[F]): DataPipelineT[F, B, Spark] =
    `this`.collectImpl(pf).flatten

  def handleError(f: Throwable => A)(
    implicit F: MonadError[F, Throwable],
    A: ClassTag[A]
  ): DataPipelineT[F, A, Spark] =
    `this`.handleErrorImpl[A](f)

  def recover(pf: PartialFunction[Throwable, A])(
    implicit F: MonadError[F, Throwable],
    A: ClassTag[A]
  ): DataPipelineT[F, A, Spark] =
    `this`.handleErrorImpl[A](pf.applyOrElse(_, (e: Throwable) => throw e))

  def recoverNonFatal(f: Throwable => A)(
    implicit F: MonadError[F, Throwable],
    A: ClassTag[A]
  ): DataPipelineT[F, A, Spark] =
    `this`.handleErrorImpl {
      case NonFatal(e) => f(e)
      case other       => throw other
    }
}
