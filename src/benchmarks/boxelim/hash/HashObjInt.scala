package benchmarks.boxelim.hash

import benchmarks.Benchmark

class HashObjInt extends HashBase with Benchmark {
  override def name = "hash-obj-int"

  override def run() = {
    super.run
    var s = 0
    for (i <- 1 to T) {
      val ht = new HashTableObj(CAP)
      var i = 0
      while (i < N) {
        ht(new Integer(i)) = new Integer(i)
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

class HashTableObj(capacity: Int) {
  val data = new Array[(Int, Int)](capacity)
  var size: Int = 0;

  private def indexFor(_key: Any): Int = {
    val key = _key.asInstanceOf[Int]
    
    var hash: Int = key.## % capacity
    while (data(hash) != null && data(hash)._1 != key) {
      hash = (hash + 1) % capacity;
    }
    hash
  }

  def apply(_key: Any): Any = {
    val key = _key.asInstanceOf[Int]
    
    val kv = data(indexFor(new Integer(key)))
    if (kv == null)
      throw new Exception("not found")
    kv._2
  }

  def update(_key: Any, _element: Any) {
    val key = _key.asInstanceOf[Int]
    val element = _element.asInstanceOf[Int]
    
    if (size == capacity)
      throw new Exception("Hash full")
    size = size + 1;
    data(indexFor(new Integer(key))) = (key, element);
  }
}
