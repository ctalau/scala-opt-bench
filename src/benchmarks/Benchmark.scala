package benchmarks

trait Benchmark {

  /**
   * These functions should be implemented by each benchmark and
   * the super implementation should be called
   */
  def run() = {}
  def setUp() = {}
  def name: String

  def timedRun(): Double = {
    setUp
    System.gc
    val tb = System.nanoTime
    run()
    val te = System.nanoTime
    return (te - tb) / 1000000;
  }
  
  def log(str: String) = //{}
    println(name + ": " + str)
}