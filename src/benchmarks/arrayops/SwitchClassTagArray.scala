package benchmarks.arrayops

final class SwitchClassTagsArray(tag: Int) extends ArrayInterface {
  import ClassTags._

  val array = newArray(size)
  
  override def newArray(len : Int) =
    tag match {
    case UNIT =>
      new Array[Unit](len)
    case BOOLEAN =>
      new Array[Boolean](len)
    case BYTE =>
      new Array[Byte](len)
    case CHAR => 
      new Array[Char](len)
    case SHORT =>
      new Array[Short](len)
    case INT =>
      new Array[Int](len)
    case LONG =>
      new Array[Long](len)
    case FLOAT =>
      new Array[Float](len)
    case DOUBLE =>
      new Array[Double](len)
    }

  override def setElement(i: Int, elem: Long) =
    tag match { 
    case UNIT =>
      array.asInstanceOf[Array[Unit]](i) = elem.asInstanceOf[Long]
    case BOOLEAN =>
      array.asInstanceOf[Array[Boolean]](i) = elem.asInstanceOf[Boolean]
    case BYTE =>
      array.asInstanceOf[Array[Byte]](i) = elem.asInstanceOf[Byte]
    case CHAR =>
      array.asInstanceOf[Array[Char]](i) = elem.asInstanceOf[Char]
    case SHORT =>
      array.asInstanceOf[Array[Short]](i) = elem.asInstanceOf[Short]
    case INT =>
      array.asInstanceOf[Array[Int]](i) = elem.asInstanceOf[Int]
    case LONG =>
      array.asInstanceOf[Array[Long]](i) = elem.asInstanceOf[Long]
    case FLOAT =>
      array.asInstanceOf[Array[Float]](i) = elem.asInstanceOf[Float]
    case DOUBLE =>
      array.asInstanceOf[Array[Double]](i) = elem.asInstanceOf[Double]
    }

  override def getElement(i: Int) = tag match {
    case UNIT =>
      array.asInstanceOf[Array[Unit]](i).asInstanceOf[Long]
    case BOOLEAN =>
      array.asInstanceOf[Array[Boolean]](i).asInstanceOf[Long]
    case BYTE =>
      array.asInstanceOf[Array[Byte]](i).asInstanceOf[Long]
    case CHAR =>
      array.asInstanceOf[Array[Char]](i).asInstanceOf[Long]
    case SHORT =>
      array.asInstanceOf[Array[Short]](i).asInstanceOf[Long]
    case INT =>
      array.asInstanceOf[Array[Int]](i).asInstanceOf[Long]
    case LONG =>
      array.asInstanceOf[Array[Long]](i).asInstanceOf[Long]
    case FLOAT =>
      array.asInstanceOf[Array[Float]](i).asInstanceOf[Long]
    case DOUBLE =>
      array.asInstanceOf[Array[Double]](i).asInstanceOf[Long]
    } 
}
