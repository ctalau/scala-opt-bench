package benchmarks.arrayops

import Conversions._

final class SwitchClassTagsArray(tag: Int) extends ArrayInterface {
  import ClassTags._

  override def name = "switch-classtag"

  val array = newArray(size)
  
  override def newArray(len : Int) =
    tag match {
    case UNIT =>
      null
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
    case BOOLEAN =>
      array.asInstanceOf[Array[Boolean]](i) = LongToBoolean(elem)
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
      array.asInstanceOf[Array[Double]](i) = LongToDouble(elem)
    }

  override def getElement(i: Int) = tag match {
    case UNIT =>
      0
    case BOOLEAN =>
      BooleanToLong(array.asInstanceOf[Array[Boolean]](i))
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
      DoubleToLong(array.asInstanceOf[Array[Double]](i))
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
    log(""+s)
  }

}
