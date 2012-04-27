package benchmarks.arrayops

import benchmarks.Benchmark
import cst._

class BoxedArrayDouble {
  var array: Array[Double] = _
  def newArray(len: Int): Unit = { array = new Array[Double](len) }
  def setElement(p: Int, elem: Any) = array(p) = elem.asInstanceOf[Double]
  def getElement(p: Int): Any = array(p).asInstanceOf[Any]
}


class BoxedArrayDoubleRunner extends Benchmark {
  
  var arr: BoxedArrayDouble = _
  override def name = "boxed"
  override def setUp = {
    arr = new BoxedArrayDouble
    arr.newArray(cst.size)
  }
  override def run() = {
    var s = 0d
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, (i.toDouble.asInstanceOf[Any]))
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += arr.getElement(i).asInstanceOf[Double]
        i += 1
      }
    }
    log(""+s)
  }

}
