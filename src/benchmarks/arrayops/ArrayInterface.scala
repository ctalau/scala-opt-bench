package benchmarks.arrayops

import benchmarks.Benchmark

import cst._

trait ArrayInterface extends Benchmark {
  def newArray(len: Int): Any
  def setElement(p:Int, elem: Long)
  def getElement(p:Int) : Long

  def size = cst.size
  
}