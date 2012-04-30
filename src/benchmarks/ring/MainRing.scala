package benchmarks.ring

import benchmarks.ComparingBenchmark
import benchmarks.CompareIteratingBenchmarks

object MainRing {
  def main(args: Array[String]) {
    val comp = new CompareIteratingBenchmarks(100,
      List(
        new RawRingSpBooleanSubtractBenchmark,
        new BoxedRingSpBooleanSubtractBenchmark,
        new RingSpBooleanSubtractBenchmark,

        new RawRingSpIntSubtractBenchmark,
        new BoxedRingSpIntSubtractBenchmark,
        new RingSpIntSubtractBenchmark,

        new RawRingSpDoubleSubtractBenchmark,
        new BoxedRingSpDoubleSubtractBenchmark,
        new RingSpDoubleSubtractBenchmark
        ))
    comp.run()
  }
}