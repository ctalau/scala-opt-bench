package benchmarks.arrayops

final class IfClassTagsArray(tag: Int) extends ArrayInterface {
  import ClassTags._

  val array = newArray(size)

  override def newArray(len: Int) =
    if (tag == UNIT) {
      new Array[Unit](len)
    } else if (tag == BOOLEAN) {
      new Array[Boolean](len)
    } else if (tag == BYTE) {
      new Array[Byte](len)
    } else if (tag == CHAR) {
      new Array[Char](len)
    } else if (tag == SHORT) {
      new Array[Short](len)
    } else if (tag == INT) {
      new Array[Int](len)
    } else if (tag == LONG) {
      new Array[Long](len)
    } else if (tag == FLOAT) {
      new Array[Float](len)
    } else if (tag == DOUBLE) {
      new Array[Double](len)
    }

  override def setElement(i: Int, elem: Long) =
    if (tag == UNIT) {
      array.asInstanceOf[Array[Unit]](i) = elem.asInstanceOf[Long]
    } else if (tag == BOOLEAN) {
      array.asInstanceOf[Array[Boolean]](i) = elem.asInstanceOf[Boolean]
    } else if (tag == BYTE) {
      array.asInstanceOf[Array[Byte]](i) = elem.asInstanceOf[Byte]
    } else if (tag == CHAR) {
      array.asInstanceOf[Array[Char]](i) = elem.asInstanceOf[Char]
    } else if (tag == SHORT) {
      array.asInstanceOf[Array[Short]](i) = elem.asInstanceOf[Short]
    } else if (tag == INT) {
      array.asInstanceOf[Array[Int]](i) = elem.asInstanceOf[Int]
    } else if (tag == LONG) {
      array.asInstanceOf[Array[Long]](i) = elem.asInstanceOf[Long]
    } else if (tag == FLOAT) {
      array.asInstanceOf[Array[Float]](i) = elem.asInstanceOf[Float]
    } else if (tag == DOUBLE) {
      array.asInstanceOf[Array[Double]](i) = elem.asInstanceOf[Double]
    }

  override def getElement(i: Int) =
    if (tag == UNIT) {
      array.asInstanceOf[Array[Unit]](i).asInstanceOf[Long]
    } else if (tag == BOOLEAN) {
      array.asInstanceOf[Array[Boolean]](i).asInstanceOf[Long]
    } else if (tag == BYTE) {
      array.asInstanceOf[Array[Byte]](i).asInstanceOf[Long]
    } else if (tag == CHAR) {
      array.asInstanceOf[Array[Char]](i).asInstanceOf[Long]
    } else if (tag == SHORT) {
      array.asInstanceOf[Array[Short]](i).asInstanceOf[Long]
    } else if (tag == INT) {
      array.asInstanceOf[Array[Int]](i).asInstanceOf[Long]
    } else if (tag == LONG) {
      array.asInstanceOf[Array[Long]](i).asInstanceOf[Long]
    } else if (tag == FLOAT) {
      array.asInstanceOf[Array[Float]](i).asInstanceOf[Long]
    } else if (tag == DOUBLE) {
      array.asInstanceOf[Array[Double]](i).asInstanceOf[Long]
    } else {
      0
    }
}

