package benchmarks.boxelim.vector

import benchmarks.Benchmark

/**
 * Both internal representation and interface are Object-based
 */
class VectorObjObj extends VectorConstants with Benchmark {
  override def name = "vector-obj-obj"

  override def run() = {
    super.run()
    val v = new VectorObjI();
    for (i <- 0 to MAX){
        v.setElem(i % N, new Integer(i));
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

class VectorObjI extends VectorConstants {
  val elems = new Array[Any](N)

  @inline
  final def getElem(i: Int): Any = {
    return elems(i);
  }

  @inline
  final def setElem(i: Int, elem: Any) {
    elems(i) = elem.asInstanceOf[Int];
  }
}
