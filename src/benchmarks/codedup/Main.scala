package benchmarks.codedup

import benchmarks.ComparingBenchmark

object Main {
  def main(args: Array[String]) {
    val comp = new ComparingBenchmark(
        List(
            new MegamorphicCodeBenchmark(), 
            new DuplicateCodeBenchmark(),
            new DuplicateOnceCodeBenchmark()))
    comp.run()
  }

}