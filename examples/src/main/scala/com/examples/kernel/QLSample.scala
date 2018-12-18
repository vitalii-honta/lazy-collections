package com.examples.kernel

import cats.implicits._
import cats.effect._
import com.github.trembita._
import com.github.trembita.ql._
import com.examples.putStrLn
import shapeless.syntax.singleton._
import shapeless._

object QLSample extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val numbers: DataPipelineT[IO, Long, Parallel] =
      DataPipelineT.liftF[IO, Long, Parallel](IO { 1L to 20L })

    val result = numbers
      .query(
        _.where(_ > 5)
          .groupBy(
            expr[Long](_ % 2 == 0) as "divisible by 2",
            expr[Long](_ % 3 == 0) as "divisible by 3",
            expr[Long](_ % 4) as "reminder of 4"
          )
          .aggregate(
            expr[Long](num => (num * num).toDouble) agg avg as "square",
            col[Long] agg count as "count",
            expr[Long](num => num * num * num * num) agg sum as "^4",
            expr[Long](_.toString) agg sum as "some name"
          )
      )
      .eval

    val numbersDP = DataPipelineT
      .liftF[IO, Long, Sequential](IO { 15L to 40L })
      .query(
        _.groupBy(
          expr[Long](_ % 2 == 0) as "divisible by 2",
          expr[Long](_ % 3 == 0) as "divisible by 3",
          expr[Long](_ % 4) as "reminder of 4",
          expr[Long](_.toString.length) as "length"
        ).aggregate(
            expr[Long](num => (num * num).toDouble) agg avg as "square",
            col[Long] agg count as "count",
            expr[Long](num => num * num * num * num) agg sum as "^4",
            expr[Long](_.toString) agg sum as "some name",
            expr[Long](_.toDouble) agg stdev as "STDEV"
          )
          .having(agg[String]("some name")(_.contains('1')))
      )
      .as[NumbersReport] // transforms directly into case class
      .eval
      .flatTap { report =>
        putStrLn(s"Report: $report")
      }

    (result.flatTap { result =>
      putStrLn("First one:") *>
        putStrLn(result.mkString("\n")) *>
        putStrLn("-------------------------")
    } *> numbersDP).as(ExitCode.Success)
  }
}

case class NumbersReport(divisibleBy2: Boolean,
                         divisibleBy3: Boolean,
                         reminderOf4: Long,
                         length: Int,
                         square: Double,
                         count: Long,
                         power4: Long,
                         someName: String,
                         stdev: Double,
                         values: Vector[Long])
