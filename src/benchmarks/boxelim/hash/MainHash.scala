package benchmarks.boxelim.hash

import benchmarks.ComparingBenchmark

object MainHash {
  def main(args: Array[String]) {
      val comp = new ComparingBenchmark(
          List(
              new HashIntInt(), 
              new HashObjObj(), 
              new HashObjInt()))
      comp.run()
  }
  
}