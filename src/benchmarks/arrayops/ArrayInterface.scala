package benchmarks.arrayops

import cst._

trait ArrayInterface {
  def newArray(len: Int): Any
  def setElement(p:Int, elem: Long)
  def getElement(p:Int) : Long
}