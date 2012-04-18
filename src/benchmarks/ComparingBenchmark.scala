package benchmarks

class ComparingBenchmark(benchmarks: List[Benchmark]) {

  var iter = 5
  var warmingUpIterations = 2
  def run() = {
    benchmarks foreach (_.setUp)
    for (i <- 1 to iter) {
      val times = benchmarks map (b => (b.name, b.timedRun))
      if (i > warmingUpIterations) {
        times foreach { case (name, time) => println(name + " took " + time + "ms") }
        println()
      }
    }
  }

}