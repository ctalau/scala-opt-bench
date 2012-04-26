package benchmarks.arrayops

import benchmarks.Benchmark

trait ArrayInterface extends Benchmark {
  def newArray(len: Int): Any
  def setElement(p:Int, elem: Long)
  def getElement(p:Int) : Long
  def size = 1000000
  def T = 1000

  override def run() = {
    super.run()
    
    var s = 0
    for (i <- 1 to T) {
      var i = 0
      while (i < size) {
        setElement(i, i)
        i += 1
      }
      i = 0
      while (i < size) {
        s += getElement(i).asInstanceOf[Int]
        i += 1
      }
    }
    println(s)
  }
}