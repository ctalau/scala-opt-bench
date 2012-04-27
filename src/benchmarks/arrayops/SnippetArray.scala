package benchmarks.arrayops
import Conversions._
import benchmarks.Benchmark

trait Snippet {
  def newArray(len: Int):Any
  def setElement(array: Any, p: Int, elem: Long)
  def getElement(array: Any, p : Int): Long
}

object SnippetInt extends Snippet {
  override def newArray(len: Int):Any = new Array[Int](len)
  override def setElement(array: Any, p: Int, elem: Long) = array.asInstanceOf[Array[Int]](p) = elem.asInstanceOf[Int]
  override def getElement(array: Any, p : Int): Long = array.asInstanceOf[Array[Int]](p).asInstanceOf[Long]
}

object SnippetBoolean extends Snippet {
  override def newArray(len: Int):Any = new Array[Boolean](len)
  override def setElement(array: Any, p: Int, elem: Long) = 
    array.asInstanceOf[Array[Boolean]](p) = LongToBoolean(elem)
  override def getElement(array: Any, p : Int): Long = 
    BooleanToLong(array.asInstanceOf[Array[Boolean]](p))
}

object SnippetDouble extends Snippet {
  override def newArray(len: Int):Any = new Array[Double](len)
  override def setElement(array: Any, p: Int, elem: Long) = 
    array.asInstanceOf[Array[Double]](p) = LongToDouble(elem)
  override def getElement(array: Any, p : Int): Long = 
    DoubleToLong(array.asInstanceOf[Array[Double]](p))
}

/**
 * The operations are implemented in a dictionary-like object
 */

final class SnippetArray(snippet : Snippet) extends ArrayInterface with Benchmark {
  override def name = "snippet"

  val array = newArray(cst.size)
  override def newArray(len: Int):Any = snippet.newArray(len)
  override def setElement(p:Int, elem: Long) = snippet.setElement(array, p, elem)
  override def getElement(p:Int) : Long = snippet.getElement(array, p)
  override def run() = {
    
    var s = 0
    for (i <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        setElement(i, i)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += getElement(i).asInstanceOf[Int]
        i += 1
      }
    }
    log(""+s)
  }

}

