package benchmarks.arrayops

import benchmarks.Benchmark
import cst._

class BoxedArrayDouble extends Benchmark {
  override def name = "boxed"

  val array: Array[Double] = newArray(cst.size).asInstanceOf[Array[Double]]

  def newArray(len: Int): Any = new Array[Double](len)

  def setElement(p: Int, elem: Any) =
    array(p) = elem.asInstanceOf[Double]
  def getElement(p: Int): Any =
    array(p).asInstanceOf[Any]

   
  override def run() = {
    super.run()
    
    var s = 0
    for (i <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        setElement(i, (i.asInstanceOf[Double].asInstanceOf[Any]))
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += getElement(i).asInstanceOf[Double].asInstanceOf[Int]
        i += 1
      }
    }
    log(""+s)
  }
}
