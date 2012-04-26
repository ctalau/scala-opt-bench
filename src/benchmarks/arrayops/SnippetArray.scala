package benchmarks.arrayops

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
  override def setElement(array: Any, p: Int, elem: Long) = array.asInstanceOf[Array[Boolean]](p) = elem.asInstanceOf[Boolean]
  override def getElement(array: Any, p : Int): Long = array.asInstanceOf[Array[Boolean]](p).asInstanceOf[Long]
}

object SnippetDouble extends Snippet {
  override def newArray(len: Int):Any = new Array[Double](len)
  override def setElement(array: Any, p: Int, elem: Long) = array.asInstanceOf[Array[Double]](p) = elem.asInstanceOf[Double]
  override def getElement(array: Any, p : Int): Long = array.asInstanceOf[Array[Double]](p).asInstanceOf[Long]
}

final class SnippetArray(snippet : Snippet) extends ArrayInterface {
  val array = newArray(size)
  override def newArray(len: Int):Any = snippet.newArray(len)
  override def setElement(p:Int, elem: Long) = snippet.setElement(array, p, elem)
  override def getElement(p:Int) : Long = snippet.getElement(array, p)
}

