package benchmarks.arrayops

import Conversions._

class SpecializedArrayInt extends ArrayInterface {
  override def name = "specialized"
  val array : Array[Int] = newArray(size).asInstanceOf[Array[Int]]

  override def newArray(len: Int): Any = new Array[Int](len)
  override def setElement(p:Int, elem: Long) = 
    array(p) = elem.asInstanceOf[Int]
  override def getElement(p:Int) : Long =
    array(p).asInstanceOf[Long]

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

class SpecializedArrayDouble extends ArrayInterface {
  override def name = "specialized"
  val array : Array[Double] = newArray(size).asInstanceOf[Array[Double]]

  override def newArray(len: Int): Any = new Array[Double](len)
  override def setElement(p:Int, elem: Long) = 
    array(p) = LongToDouble(elem)
  override def getElement(p:Int) : Long =
    DoubleToLong(array(p))

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

class SpecializedArrayBoolean extends ArrayInterface {
  override def name = "specialized"
  val array : Array[Boolean] = newArray(size).asInstanceOf[Array[Boolean]]

  override def newArray(len: Int): Any = new Array[Boolean](len)
  override def setElement(p:Int, elem: Long) = 
    array(p) = LongToBoolean(elem)
  override def getElement(p:Int) : Long =
    BooleanToLong(array(p))
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