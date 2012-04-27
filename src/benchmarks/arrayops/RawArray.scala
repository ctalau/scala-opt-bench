package benchmarks.arrayops

import benchmarks.Benchmark
import cst._
import benchmarks.Benchmark

class RawArrayInt {
  var array: Array[Int] = _
  def newArray(len: Int): Unit = { array = new Array[Int](len) }
  def setElement(p: Int, elem: Int) = array(p) = elem
  def getElement(p: Int): Int = array(p)
}

class RawArrayIntRunner extends Benchmark {
  override def name = "raw-int"
  var arr: RawArrayInt = _
  
  override def setUp() = {
    arr = new RawArrayInt
    arr.newArray(cst.size)
  }
  
  override def run() = {
    var s = 0
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, i)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += arr.getElement(i)
        i += 1
      }
    }
    log(""+s)
  }
}

class RawArrayBoolean {
  var array: Array[Boolean] = _
  def newArray(len: Int): Unit = { array = new Array[Boolean](len) }
  def setElement(p: Int, elem: Boolean) = array(p) = elem
  def getElement(p: Int): Boolean = array(p)
}

class RawArrayBooleanRunner extends Benchmark {
  override def name = "raw-bool"
  var arr: RawArrayBoolean = _
  
  override def setUp() = {
    arr = new RawArrayBoolean
    arr.newArray(cst.size)
  }
  
  override def run() = {
    var s = true
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
       arr.setElement(i, i % 2 == 0)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s &&= arr.getElement(i)
        i += 1
      }
    }
    log(""+s)
  }
}


class RawArrayDouble {
  var array: Array[Double] = _
  def newArray(len: Int): Unit = { array = new Array[Double](len) }
  def setElement(p: Int, elem: Double) = array(p) = elem
  def getElement(p: Int): Double = array(p)
}

class RawArrayDoubleRunner extends Benchmark {
  override def name = "raw-double"
  var arr: RawArrayDouble = _
  
  override def setUp() = {
    arr = new RawArrayDouble
    arr.newArray(cst.size)
  }
  
  override def run() = {
    var s = 0d
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, i.toDouble)
        i += 1
      }
      i = 0
      while (i < cst.size) {
        s += arr.getElement(i)
        i += 1
      }
    }
    log(""+s)
  }
}

