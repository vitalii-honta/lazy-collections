package trembita

import cats.kernel.Monoid
import trembita.outputs.internal._
import scala.language.higherKinds

object Output {
  @inline def collection[Col[x] <: Iterable[x]]: collectionDsl[Col]      = new collectionDsl[Col]
  val vector: collectionDsl[Vector]                                      = collection[Vector]
  val set: collectionDsl[Set]                                            = collection[Set]
  @inline def foreach[A](f: A => Unit): foreachDsl[A]                    = new foreachDsl[A](f)
  @inline def reduce[A](f: (A, A) => A): reduceDsl[A]                    = new reduceDsl[A](f)
  @inline def combineAll[A](implicit monoid: Monoid[A])                  = new foldDsl[A](monoid.empty -> monoid.combine)
  @inline def reduceOpt[A](f: (A, A) => A): reduceOptDsl[A]              = new reduceOptDsl[A](f)
  @inline def fold[A](zero: A)(f: (A, A) => A): foldDsl[A]               = new foldDsl[A](zero -> f)
  @inline def foldLeft[A, B](zero: B)(f: (B, A) => B): foldLeftDsl[A, B] = new foldLeftDsl[A, B](zero -> f)
  val size: sizeDsl                                                      = new sizeDsl()
  @inline def ignore[A]                                                  = foreach[A](_ => {})
}