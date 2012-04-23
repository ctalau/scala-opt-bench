package benchmarks.primbox

import benchmarks.ComparingBenchmark

object MainPrimBox {
  def main(args: Array[String]): Unit = {
     val comp = new ComparingBenchmark(
        List(
            new BoxToDouble(), 
            new BoxToAny(),
            new NotBox()))
    comp.run()
  }

}