package trembita.ql

import trembita.Environment
import trembita.ql.GroupingCriteria.{&::, GNil}
import trembita.ql.QueryBuilder.GroupBy
import scala.language.higherKinds

trait groupBy22[F[_], Er, A, E <: Environment] { self: QueryBuilder[F, Er, A, E] =>

  /**
    * Like Group By clause in SQL
    *
    **/
  def groupBy[T, H <: :@[_, _]](f: A => H): GroupBy[F, Er, A, E, H &:: GNil] =
    new GroupBy[F, Er, A, E, H &:: GNil](pipeline, a => f(a) &:: GNil, None)

  def groupBy[T, H1 <: :@[_, _], H2 <: :@[_, _]](
      f1: A => H1,
      f2: A => H2
  ): GroupBy[F, Er, A, E, H1 &:: H2 &:: GNil] =
    new GroupBy[F, Er, A, E, H1 &:: H2 &:: GNil](pipeline, a => f1(a) &:: f2(a) &:: GNil, None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        GNil
    ](pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
        GNil,
      None)

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _],
      H18 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17,
      f18: A => H18
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      H18 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        H18 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
          f18(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _],
      H18 <: :@[_, _],
      H19 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17,
      f18: A => H18,
      f19: A => H19
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      H18 &::
      H19 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        H18 &::
        H19 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
          f18(a) &::
          f19(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _],
      H18 <: :@[_, _],
      H19 <: :@[_, _],
      H20 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17,
      f18: A => H18,
      f19: A => H19,
      f20: A => H20
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      H18 &::
      H19 &::
      H20 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        H18 &::
        H19 &::
        H20 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
          f18(a) &::
          f19(a) &::
          f20(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _],
      H18 <: :@[_, _],
      H19 <: :@[_, _],
      H20 <: :@[_, _],
      H21 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17,
      f18: A => H18,
      f19: A => H19,
      f20: A => H20,
      f21: A => H21
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      H18 &::
      H19 &::
      H20 &::
      H21 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        H18 &::
        H19 &::
        H20 &::
        H21 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
          f18(a) &::
          f19(a) &::
          f20(a) &::
          f21(a) &::
        GNil,
      None
    )

  def groupBy[
      T,
      H1 <: :@[_, _],
      H2 <: :@[_, _],
      H3 <: :@[_, _],
      H4 <: :@[_, _],
      H5 <: :@[_, _],
      H6 <: :@[_, _],
      H7 <: :@[_, _],
      H8 <: :@[_, _],
      H9 <: :@[_, _],
      H10 <: :@[_, _],
      H11 <: :@[_, _],
      H12 <: :@[_, _],
      H13 <: :@[_, _],
      H14 <: :@[_, _],
      H15 <: :@[_, _],
      H16 <: :@[_, _],
      H17 <: :@[_, _],
      H18 <: :@[_, _],
      H19 <: :@[_, _],
      H20 <: :@[_, _],
      H21 <: :@[_, _],
      H22 <: :@[_, _]
  ](
      f1: A => H1,
      f2: A => H2,
      f3: A => H3,
      f4: A => H4,
      f5: A => H5,
      f6: A => H6,
      f7: A => H7,
      f8: A => H8,
      f9: A => H9,
      f10: A => H10,
      f11: A => H11,
      f12: A => H12,
      f13: A => H13,
      f14: A => H14,
      f15: A => H15,
      f16: A => H16,
      f17: A => H17,
      f18: A => H18,
      f19: A => H19,
      f20: A => H20,
      f21: A => H21,
      f22: A => H22
  ): GroupBy[
    F,
    Er,
    A,
    E,
    H1 &::
      H2 &::
      H3 &::
      H4 &::
      H5 &::
      H6 &::
      H7 &::
      H8 &::
      H9 &::
      H10 &::
      H11 &::
      H12 &::
      H13 &::
      H14 &::
      H15 &::
      H16 &::
      H17 &::
      H18 &::
      H19 &::
      H20 &::
      H21 &::
      H22 &::
      GNil
  ] =
    new GroupBy[
      F,
      Er,
      A,
      E,
      H1 &::
        H2 &::
        H3 &::
        H4 &::
        H5 &::
        H6 &::
        H7 &::
        H8 &::
        H9 &::
        H10 &::
        H11 &::
        H12 &::
        H13 &::
        H14 &::
        H15 &::
        H16 &::
        H17 &::
        H18 &::
        H19 &::
        H20 &::
        H21 &::
        H22 &::
        GNil
    ](
      pipeline,
      a =>
        f1(a) &::
          f2(a) &::
          f3(a) &::
          f4(a) &::
          f5(a) &::
          f6(a) &::
          f7(a) &::
          f8(a) &::
          f9(a) &::
          f10(a) &::
          f11(a) &::
          f12(a) &::
          f13(a) &::
          f14(a) &::
          f15(a) &::
          f16(a) &::
          f17(a) &::
          f18(a) &::
          f19(a) &::
          f20(a) &::
          f21(a) &::
          f22(a) &::
        GNil,
      None
    )
}
