package benchmarks.boxelim.hash

import benchmarks.Benchmark

class HashObjObj extends HashBase with Benchmark {
  override def name = "hash-obj-obj"

  override def run() = {
    super.run
    var s = 0
    for (i <- 1 to T) {
      val ht = new HashTableObjI(CAP)
      var i = 0
      while (i < N) {
        ht(new Integer(i)) = i
        i = i + INC
      }
      
      i = 0
      while (i < N) {
        s = s + ht(new Integer(i)).asInstanceOf[Int]
        i = i + INC
      }
    }
    log("" + s)
  }
}

class HashTableObjI(capacity: Int) {
  val data = new Array[(Any, Any)](capacity)
  var size: Int = 0;

  private def indexFor(key: Any): Int = {
    var hash: Int = key.## % capacity
    while (data(hash) != null && data(hash)._1 != key) {
      hash = (hash + 1) % capacity;
    }
    hash
  }

  def apply(key: Any): Any = {
    val kv = data(indexFor(key))
    if (kv == null)
      throw new Exception("not found")
    kv._2
  }

  def update(key: Any, element: Any) {
    if (size == capacity)
      throw new Exception("Hash full")
    size = size + 1;
    data(indexFor(key)) = (key, element);
  }
}
