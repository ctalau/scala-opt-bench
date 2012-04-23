package benchmarks.primbox

import benchmarks.Benchmark

class BoxToAny extends Benchmark {
  val a = new Array[Any](1000);

  override def name = "box-to-any"
  override def run() = {
    super.run
    var s: Long = 0;
    val t1 = System.nanoTime
    for (t <- 0 to 10000) {
      var i:Int = 0;
      while (i < a.length) {
        a(i) = i;
        i = i + 1
      }

      i = 0;
      while (i < a.length) {
        s = s + a(i).asInstanceOf[Int];
        i = i + 1
      }
    }
    log(""+s);
  }
}