package com.github.trembita.experimental.spark

import cats.{Functor, Id}
import com.github.trembita._
import org.apache.spark.rdd.RDD

import scala.language.higherKinds
import scala.reflect.ClassTag

sealed trait Spark extends Environment {
  final type Repr[X] = RDD[X]
  final type Run[G[_]]     = RunOnSpark[G]
  final type Result[X]     = X

  def toVector[A](repr: RDD[A]): Vector[A] = repr.collect().toVector

  def groupBy[A, K: ClassTag](vs: Repr[A])(f: A => K): Repr[(K, Iterable[A])] =
    vs.groupBy(f)
  def collect[A, B: ClassTag](
      repr: Repr[A]
  )(pf: PartialFunction[A, B]): Repr[B] =
    repr.collect(pf)
  def concat[A](xs: Repr[A], ys: Repr[A]): Repr[A]                = xs union ys
  def zip[A, B: ClassTag](xs: Repr[A], ys: Repr[B]): Repr[(A, B)] = xs zip ys

  def distinctKeys[A: ClassTag, B: ClassTag](repr: RDD[(A, B)]): RDD[(A, B)] =
    repr.reduceByKey((a, b) => a)

  def memoize[A: ClassTag](xs: RDD[A]): RDD[A] = xs.persist()

  def absorb[F[_], A](fa: Result[F[A]]): F[A] = fa

  val FlatMapResult: ApplicativeFlatMap[Id] = ApplicativeFlatMap.id

  val FlatMapRepr: ApplicativeFlatMap[RDD] =
    new ApplicativeFlatMap[RDD] {
      def flatMap[A, B: ClassTag](fa: RDD[A])(f: A => RDD[B]): RDD[B] =
        fa.flatMap(f(_).collect())

      def map[A, B: ClassTag](fa: RDD[A])(f: A => B): RDD[B] = fa.map(f)
    }

  val TraverseRepr: TraverseTag[RDD, RunOnSpark] =
    new TraverseTag[RDD, RunOnSpark] {
      def traverse[G[_], A, B: ClassTag](
          fa: RDD[A]
      )(f: A => G[B])(implicit G: RunOnSpark[G]): G[RDD[B]] = G.lift {
        G.traverse(fa)(f)
      }
    }

  def foreach[A](repr: Repr[A])(f: A => Unit): Result[Unit] =
    repr.foreach(f)
}

object Spark {
  implicit val spark: Spark = new Spark {}
}
