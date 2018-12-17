package com.github.trembita.operations

import scala.collection.parallel.immutable.ParVector
import scala.language.higherKinds
import scala.reflect.ClassTag
import scala.collection.JavaConverters._

trait CanSort[F[_]] {
  def sorted[A: Ordering: ClassTag](fa: F[A]): F[A]
  def sortedBy[A: ClassTag, B: Ordering: ClassTag](fa: F[A])(f: A => B): F[A]
}

object CanSort {
  implicit val canSortVector: CanSort[Vector] = new CanSort[Vector] {
    def sorted[A: Ordering: ClassTag](fa: Vector[A]): Vector[A] = fa.sorted
    def sortedBy[A: ClassTag, B: Ordering: ClassTag](fa: Vector[A])(f: A => B): Vector[A] =
      fa.sortBy(f)
  }

  implicit val canSortParVector: CanSort[ParVector] = new CanSort[ParVector] {
    def sorted[A: Ordering: ClassTag](fa: ParVector[A]): ParVector[A] =
      fa.seq.sorted.par
    def sortedBy[A: ClassTag, B: Ordering: ClassTag](fa: ParVector[A])(f: A => B): ParVector[A] =
      fa.seq.sortBy(f).par
  }
}
