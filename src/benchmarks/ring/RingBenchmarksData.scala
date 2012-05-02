package benchmarks.ring

import scala.util.Random._

object RingBenchmarks {
  def init[A: Manifest](size: Int)(init: => A) = {
    val data = Array.ofDim[A](size)
    for (i <- 0 until size) data(i) = init
    data
  }

  var size: Int = 10000000
  var booleans: Array[Boolean] = null
  var ints: Array[Int] = null
  var doubles: Array[Double] = null

  booleans = init(size)(nextBoolean)
  ints = init(size)(nextInt)
  doubles = init(size)(nextDouble)
}
