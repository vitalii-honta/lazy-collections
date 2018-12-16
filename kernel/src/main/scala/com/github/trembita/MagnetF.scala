package com.github.trembita

import scala.language.higherKinds
import scala.language.implicitConversions

trait Magnet[A, B, Ex <: Execution] extends Serializable {
  def prepared: A => B
}

trait PartialMagnet[A, B, Ex <: Execution] extends Serializable {
  def prepared: PartialFunction[A, B]
}

trait MagnetF[F[_], A, B, Ex <: Execution] extends Serializable {
  def prepared: A => F[B]
}

trait PartialMagnetF[F[_], A, B, Ex <: Execution] extends Serializable {
  def prepared: PartialFunction[A, F[B]]
}

trait standardMagnets {
  implicit def prepareSequential[A, B](f: A => B): Magnet[A, B, Sequential] =
    new Magnet[A, B, Sequential] {
      def prepared: A => B = f
    }

  implicit def prepareParallel[A, B](f: A => B): Magnet[A, B, Parallel] =
    new Magnet[A, B, Parallel] {
      def prepared: A => B = f
    }

  implicit def preparePartialSequential[A, B](
    pf: PartialFunction[A, B]
  ): PartialMagnet[A, B, Sequential] =
    new PartialMagnet[A, B, Sequential] {
      def prepared: PartialFunction[A, B] = pf
    }

  implicit def preparePartialParallel[A, B](
    pf: PartialFunction[A, B]
  ): PartialMagnet[A, B, Parallel] =
    new PartialMagnet[A, B, Parallel] {
      def prepared: PartialFunction[A, B] = pf
    }

  implicit def prepareSequentialF[F[_], A, B](
    f: A => F[B]
  ): MagnetF[F, A, B, Sequential] = new MagnetF[F, A, B, Sequential] {
    def prepared: A => F[B] = f
  }

  implicit def prepareParallelF[F[_], A, B](
    f: A => F[B]
  ): MagnetF[F, A, B, Parallel] = new MagnetF[F, A, B, Parallel] {
    def prepared: A => F[B] = f
  }

  implicit def preparePartialSequentialF[F[_], A, B](
    pf: PartialFunction[A, F[B]]
  ): PartialMagnetF[F, A, B, Sequential] =
    new PartialMagnetF[F, A, B, Sequential] {
      def prepared: PartialFunction[A, F[B]] = pf
    }

  implicit def preparePartialParallelF[F[_], A, B](
    pf: PartialFunction[A, F[B]]
  ): PartialMagnetF[F, A, B, Parallel] =
    new PartialMagnetF[F, A, B, Parallel] {
      def prepared: PartialFunction[A, F[B]] = pf
    }
}
