package benchmarks.ring

import benchmarks.ComparingBenchmark
import benchmarks.CompareIteratingBenchmarks

//benchmarks.ring.RawRingSpBooleanSubtractBenchmark took    0.0ms
//benchmarks.ring.BoxedRingSpBooleanSubtractBenchmark took  69.0ms
//benchmarks.ring.RingSpBooleanSubtractBenchmark took       0.0ms
//benchmarks.ring.RawRingSpIntSubtractBenchmark took        0.0ms
//benchmarks.ring.BoxedRingSpIntSubtractBenchmark took      267.0ms
//benchmarks.ring.RingSpIntSubtractBenchmark took           0.0ms
//benchmarks.ring.RawRingSpDoubleSubtractBenchmark took     0.0ms
//benchmarks.ring.BoxedRingSpDoubleSubtractBenchmark took   121.0ms
//benchmarks.ring.RingSpDoubleSubtractBenchmark took        54.0ms

object MainRing {
  def main(args: Array[String]) {
    val comp = new CompareIteratingBenchmarks(1,
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