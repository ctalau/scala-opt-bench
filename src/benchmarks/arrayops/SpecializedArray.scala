package benchmarks.arrayops

import Conversions._
import benchmarks.Benchmark

/**
 * Specialized representation, but uniform interface
 */
class SpecializedArrayInt extends ArrayInterface {
  var array : Array[Int] = _
  override def newArray(len: Int): Unit = { array = new Array[Int](len) }
  override def setElement(p:Int, elem: Long) = array(p) = LongToInt(elem)
  override def getElement(p:Int) : Long = IntToLong(array(p))
}

class SpecializedArrayIntRunner extends Benchmark {
  var arr: SpecializedArrayInt = new SpecializedArrayInt 
  override def name = "specialized-int"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = 0
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, IntToLong(i))
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += LongToInt(arr.getElement(i))
        i += 1
      }
    }
    log(""+s)
  }
}

class SpecializedArrayDouble extends ArrayInterface {
  var array : Array[Double] = _
  override def newArray(len: Int): Unit = { array = new Array[Double](len) }
  override def setElement(p:Int, elem: Long) = array(p) = LongToDouble(elem)
  override def getElement(p:Int) : Long = DoubleToLong(array(p))
}

class SpecializedArrayDoubleRunner extends Benchmark {
  var arr: SpecializedArrayDouble = new SpecializedArrayDouble 
  override def name = "specialized-double"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = 0d
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, DoubleToLong(i.toDouble))
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += LongToDouble(arr.getElement(i))
        i += 1
      }
    }
    log(""+s)
  }
}

class SpecializedArrayBoolean extends ArrayInterface {
  var array : Array[Boolean] = _
  override def newArray(len: Int): Unit = { array = new Array[Boolean](len) }
  override def setElement(p:Int, elem: Long) = array(p) = LongToBoolean(elem)
  override def getElement(p:Int) : Long = BooleanToLong(array(p))
}

class SpecializedArrayBooleanRunner extends Benchmark {
  var arr: SpecializedArrayBoolean = new SpecializedArrayBoolean
  override def name = "specialized-boolean"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = true
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, BooleanToLong(i%2 == 0))
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s ^= LongToBoolean(arr.getElement(i))
        i += 1
      }
    }
    log(""+s)
  }
}













class DupSpecializedArrayInt {
  var array : Array[Int] = _
  def newArray(len: Int): Unit = { array = new Array[Int](len) }
  def setElement(p:Int, elem_Long: Long, elem_Double: Double) = array(p) = LongToInt(elem_Long)
  def getElement_Long(p:Int) : Long = IntToLong(array(p))
  def getElement_Double(p:Int) : Double = 0d
}

class DupSpecializedArrayIntRunner extends Benchmark {
  var arr: DupSpecializedArrayInt = new DupSpecializedArrayInt 
  override def name = "DupSpecialized-int"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = 0
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, IntToLong(i), 0d)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += LongToInt(arr.getElement_Long(i))
        i += 1
      }
    }
    log(""+s)
  }
}

class DupSpecializedArrayDouble {
  var array : Array[Double] = _
  def newArray(len: Int): Unit = { array = new Array[Double](len) }
  def setElement(p:Int, elem_Long: Long, elem_Double: Double) = array(p) = elem_Double
  def getElement_Long(p:Int) : Long = 0
  def getElement_Double(p:Int) : Double = array(p)
}

class DupSpecializedArrayDoubleRunner extends Benchmark {
  var arr: DupSpecializedArrayDouble = new DupSpecializedArrayDouble 
  override def name = "DupSpecialized-double"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = 0d
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, 0, i.toDouble)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += arr.getElement_Double(i)
        i += 1
      }
    }
    log(""+s)
  }
}

class DupSpecializedArrayBoolean {
  var array : Array[Boolean] = _
  def newArray(len: Int): Unit = { array = new Array[Boolean](len) }
  def setElement(p:Int, elem_Long: Long, elem_Double: Double) = array(p) = LongToBoolean(elem_Long)
  def getElement_Long(p:Int) : Long = BooleanToLong(array(p))
  def getElement_Double(p:Int) : Double = 0d

}

class DupSpecializedArrayBooleanRunner extends Benchmark {
  var arr: DupSpecializedArrayBoolean = new DupSpecializedArrayBoolean
  override def name = "DupSpecialized-boolean"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = true
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, BooleanToLong(i%2 == 0), 0d)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s ^= LongToBoolean(arr.getElement_Long(i))
        i += 1
      }
    }
    log(""+s)
  }
}
