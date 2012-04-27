package benchmarks.arrayops

final class IfClassTagsArray(tag: Int) extends ArrayInterface {
  import ClassTags._
  import Conversions._

  override def name = "if-classtag"

  val array = newArray(size)

  override def newArray(len: Int) =
    if (tag == UNIT) {
      null
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
    } else if (tag == BOOLEAN) {
      array.asInstanceOf[Array[Boolean]](i) = LongToBoolean(elem)
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
      array.asInstanceOf[Array[Double]](i) = LongToDouble(elem)
    }

  override def getElement(i: Int): Long =
    if (tag == UNIT) {
      0
    } else if (tag == BOOLEAN) {
      BooleanToLong(array.asInstanceOf[Array[Boolean]](i))
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
      DoubleToLong(array.asInstanceOf[Array[Double]](i))
    } else {
      0
    }
  override def run() = {
    super.run()

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
    log("" + s)
  }

}

