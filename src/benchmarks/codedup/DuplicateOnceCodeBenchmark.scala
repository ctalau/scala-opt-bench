package benchmarks.codedup

import benchmarks.Benchmark

/**
 * We use only the one locally duplicated function
 */
class DuplicateOnceCodeBenchmark extends MegaDupConstants with Benchmark {
  override def name = "duponce-code"

  override def run() = {
    super.run

    var s1 = 0;
    foreach[Int, Unit](a, e => s1 = s1 + e * (e) + 1)

    var s2 = 0;
    foreach[Int, Unit](a, e => s2 = s2 + e * (e) + 2)

    var s3 = 0;
    foreach[Int, Unit](a, e => s3 = s3 + e * (e) + 3)

    var s4 = 0;
    foreach[Int, Unit](a, e => s4 = s4 + e * (e) + 3)
    
    log("" + s1 + " " + s2 + " " + s3 + " " + s4)
  }

  def foreach[A, U](a: Array[A], f: A => U) = {
    var i = 0;
    val len = a.length
    while (i < len) {
      f(a(i))
      i = i + 1
    }
  }
}

