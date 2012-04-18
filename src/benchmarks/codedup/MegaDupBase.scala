package benchmarks.codedup

import benchmarks.Benchmark

class MegaDupConstants extends Benchmark{
  def N = 10000000

  val a = new Array[Int](N)

  override def setUp() = {
    super.setUp
    var i = 0
    while (i < a.length) {
      a(i) = i*i*i
      i = i + 1
    }
  }
}