package benchmarks.boxelim

import benchmarks.Benchmark
/**
 * Internal representation of Vector is Int-based and interface is Int-based
 */
class VectorIntInt extends VectorConstants with Benchmark {
  override def name = "vector-int-int"

  override def run() = {
    super.run()
    val v = new VectorInt();
    for (i <- 0 to MAX) {
      v.setElem(i % N, i);
    }
    var sum = 0;
    for (i <- 0 to MAX) {
      sum = sum + v.getElem(i % N);
    }
    log("" + sum);
  }

  override def setUp() = {
    super.setUp()

  }
}

class VectorInt extends VectorConstants {
  val elems = new Array[Int](N)

  @inline
  final def getElem(i: Int): Int = {
    return elems(i);
  }

  @inline
  final def setElem(i: Int, elem: Int) {
    elems(i) = elem;
  }
}
