package benchmarks.boxelim.list

import benchmarks.ComparingBenchmark

object MainList
{
  def main(args: Array[String]) {
      val comp = new ComparingBenchmark(
          List(
              new ListObjObj(),
              new ListIntInt(),
              new ListObjInt()
              )) 
      comp.run()
  }
  
}