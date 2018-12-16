package com.examples.spark

import java.util.concurrent.Executors
import com.github.trembita._
import com.github.trembita.experimental.spark._
import org.apache.spark._
import cats.syntax.all._
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

/**
  * To run this example, you need a spark-cluster.
  * Use docker-compose to deploy one
  *
  * @see resources/spark/cluster
  * */
object Main {
  val cahedThreadPool =
    ExecutionContext.fromExecutor(Executors.newCachedThreadPool())
  def main(args: Array[String]): Unit = {
    @transient implicit val trembitaSpark: SparkContext =
      new SparkContext("spark://spark-master:7077", "trembita-spark")
    implicit val timeout: Timeout = Timeout(5.minutes)

    val numbers = DataPipelineT[Future, Int](1, 2, 3, 20, 40, 60)
      .to[Spark]
      // will be executed on spark
      .map(_ + 1)
      .mapM { i: Int =>
        val n = Future { i + 1 }(cahedThreadPool)
        val b = Future {
          val x = 1 + 2
          x * 3
        }.flatTap(
          xx =>
            Future {
              println(s"spark debug: $xx") // you won't see this in submit logs
          }
        )

        (for {
          nx <- n
          bx <- b
          if nx > bx
        } yield nx + bx).attempt
      }
      .map(_.getOrElse(-100500))
      // will be executed locally in parallel
      .to[Parallel]
      .log(i => s"parallel debug: $i") // you will see it in console
      .map(_ + 1)

    try {
      println("TREMBITA EVAL")
      val result = Await.result(numbers.eval, Duration.Inf)
      println(result)
    } finally {
      trembitaSpark.stop()
    }
  }
}
