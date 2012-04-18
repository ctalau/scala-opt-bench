package benchmarks

trait Benchmark {
  /**
   * These functions should be implemented by each benchmark and
   * the super implementation should be called
   */
  var warmingUpIterations = 2
  private var iteration = 0
  private var isWarmingUp = true
  def run() = { 
    iteration = iteration + 1; 
    if (iteration == warmingUpIterations + 1) {
      isWarmingUp = false
    }
  }
  def setUp() = {
    iteration = 0;
    isWarmingUp = true;
  }
  def name = "untitled"
  
  def timedRun(): Double = {
    val tb = System.nanoTime
    run()
    val te = System.nanoTime
    return (te - tb) / 1000000;
  }

  def log(s: String) = {
    if (!isWarmingUp) {
      println(name + " - " + s)
    }
  }
}