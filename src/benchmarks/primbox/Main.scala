package benchmarks.primbox

import benchmarks.ComparingBenchmark

object Main {
  def main(args: Array[String]): Unit = {
     val comp = new ComparingBenchmark(
        List(
            new BoxToDouble(), 
            new BoxToAny(),
            new NotBox()))
    comp.run()
  }

}