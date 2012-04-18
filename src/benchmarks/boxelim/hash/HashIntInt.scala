package benchmarks.boxelim.hash

import benchmarks.Benchmark

class HashIntInt extends HashBase with Benchmark {
  override def name = "hash-int-int"

  override def run() = {
    super.run
    var s = 0
    for (i <- 1 to T) {
      val ht = new HashTable(CAP)
      var i = 0
      while (i < N) {
        ht(i) = i
        i = i + INC
      }

      i = 0
      while (i < N) {
        s = s + ht(i)
        i = i + INC
      }
    }
    log("" + s)
  }
}

class HashTable(capacity: Int) {
  val data = new Array[(Int, Int)](capacity)
  var size: Int = 0;

  private def indexFor(key: Int): Int = {
    var hash: Int = key.## % capacity
    while (data(hash) != null && data(hash)._1 != key) {
      hash = (hash + 1) % capacity;
    }
    hash
  }

  def apply(key: Int): Int = {
    val kv = data(indexFor(key))
    if (kv == null)
      throw new Exception("not found")
    kv._2
  }

  def update(key: Int, element: Int) {
    if (size == capacity)
      throw new Exception("Hash full")
    size = size + 1;
    data(indexFor(key)) = (key, element);
  }
}
