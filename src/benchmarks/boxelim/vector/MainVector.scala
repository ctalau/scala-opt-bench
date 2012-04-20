package benchmarks.boxelim.vector

import benchmarks.ComparingBenchmark

/**
 * Vector benchmark
 */
object MainVector {
  def main(args: Array[String]) {
      val comp = new ComparingBenchmark(
          List(
              new VectorIntInt(), 
              new VectorObjObj(), 
              new VectorIntObj()))
      comp.run()
  }
  
}