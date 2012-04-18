package benchmarks.codedup

import benchmarks.Benchmark

/**
 * In this scenario, the foreach method becomes megamorphic
 */
class MegamorphicCodeBenchmark extends MegaDupConstants with Benchmark {
  override def name = "mega-code"

    
  override def run() = {
    super.run

    var s1 = 0;
    a.foreach(e => s1 = s1 + e * e + 1)

    var s2 = 0;
    a.foreach(e => s2 = s2 + e * (e) + 2)

    var s3 = 0;
    a.foreach(e => s3 = s3 + e * (e) + 3)

    var s4 = 0;
    a.foreach(e => s4 = s4 + e * (e) + 3)
    log("" + s1 + " " + s2 + " " + s3 + " " + s4)
  }
}