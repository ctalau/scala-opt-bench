package benchmarks.boxelim

import benchmarks.Benchmark

/**
 * Internal representation of vector is Int-based and the interface is Object-based
 */
class VectorIntObj extends VectorConstants with Benchmark {
  override def name = "vector-int-obj"

  override def run() = {
    super.run()
    val v = new VectorObj();
    for (i <- 0 to MAX){
        v.setElem(i % N, i);
    }
    var sum = 0;
    for (i <- 0 to MAX){
       sum = sum + v.getElem(i % N).asInstanceOf[Int];
    }
    log("" + sum);
  }

  override def setUp() = {
    super.setUp()

  }
}

class VectorObj extends VectorConstants {
  val elems = new Array[Int](N)

  @inline
  final def getElem(i: Int): Any = {
    return elems(i);
  }

  @inline
  final def setElem(i: Int, elem: Any) {
    elems(i) = elem.asInstanceOf[Int];
  }
}
