package benchmarks.arrayops

import benchmarks.Benchmark

import cst._

class RawArrayInt extends Benchmark {
  override def name = "raw"

  val array: Array[Int] = newArray(cst.size)

  def newArray(len: Int): Array[Int] = new Array[Int](len)

  def setElement(p: Int, elem: Int) =
    array(p) = elem
  def getElement(p: Int): Int =
    array(p)

   
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


class RawArrayBoolean extends Benchmark {
  override def name = "raw"

  val array: Array[Boolean] = newArray(cst.size)

  def newArray(len: Int): Array[Boolean] = new Array[Boolean](len)

  def setElement(p: Int, elem: Boolean) =
    array(p) = elem
  def getElement(p: Int): Boolean =
    array(p)

   
  override def run() = {
    super.run()
    
    var s = 0
    for (i <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        setElement(i, if(i==0) false else true)
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


class RawArrayDouble extends Benchmark {
  override def name = "raw"

  val array: Array[Double] = newArray(cst.size)

  def newArray(len: Int): Array[Double] = new Array[Double](len)

  def setElement(p: Int, elem: Double) =
    array(p) = elem
  def getElement(p: Int): Double =
    array(p)

   
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
