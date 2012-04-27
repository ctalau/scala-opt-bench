package benchmarks.arrayops

import Conversions._
import benchmarks.Benchmark
import annotation.switch


import ClassTags._

final class SwitchClassTagsArray(tag: Byte) {
  var array : Any = _
  
  def newArray(len : Int) = 
    array = ((tag: @switch) match {
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
    })
  
  def setElement(i: Int, elem: Long): Unit =
    (tag: @switch) match { 
    case DOUBLE =>
    array.asInstanceOf[Array[Double]](i) = LongToDouble(elem)
    case BOOLEAN =>
      array.asInstanceOf[Array[Boolean]](i) = LongToBoolean(elem)
    case INT =>
      array.asInstanceOf[Array[Int]](i) = LongToInt(elem)
//    case LONG =>
//      array.asInstanceOf[Array[Long]](i) = elem.asInstanceOf[Long]
//    case FLOAT =>
//      array.asInstanceOf[Array[Float]](i) = elem.asInstanceOf[Float]
//    case UNIT =>
//      ()
//    case BYTE =>
//      array.asInstanceOf[Array[Byte]](i) = elem.asInstanceOf[Byte]
//    case CHAR =>
//      array.asInstanceOf[Array[Char]](i) = elem.asInstanceOf[Char]
//    case SHORT =>
//      array.asInstanceOf[Array[Short]](i) = elem.asInstanceOf[Short]
    }

  def getElement(i: Int): Long = (tag: @switch) match {
    case DOUBLE =>
      DoubleToLong(array.asInstanceOf[Array[Double]](i))
    case BOOLEAN =>
      BooleanToLong(array.asInstanceOf[Array[Boolean]](i))
    case INT =>
      IntToLong(array.asInstanceOf[Array[Int]](i))
//    case LONG =>
//      array.asInstanceOf[Array[Long]](i)
//    case FLOAT =>
//      array.asInstanceOf[Array[Float]](i).asInstanceOf[Long]
//    case UNIT =>
//      0
//    case BYTE =>
//      array.asInstanceOf[Array[Byte]](i)
//    case CHAR =>
//      array.asInstanceOf[Array[Char]](i)
//    case SHORT =>
//      array.asInstanceOf[Array[Short]](i)
    } 
}


class SwitchClassTagBooleanRunner extends Benchmark {
  var arr: SwitchClassTagsArray = new SwitchClassTagsArray(BOOLEAN)
  override def name = "switch-boolean"
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
        s &&= LongToBoolean(arr.getElement(i))
        i += 1
      }
    }
    log(""+s)
  }
}


class SwitchClassTagArrayIntRunner extends Benchmark {
  var arr: SwitchClassTagsArray = new SwitchClassTagsArray(INT)
  override def name = "switch-int"
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

class SwitchClassTagArrayDoubleRunner extends Benchmark {
  var arr: SwitchClassTagsArray = new SwitchClassTagsArray(DOUBLE) 
  override def name = "switch-double"
  override def setUp = arr.newArray(cst.size)
  override def run() = {
    var s = 0d
    for (j <- 1 to cst.T) {
      var i = 0
      while (i < cst.size) {
        arr.setElement(i, DoubleToLong(i))
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

