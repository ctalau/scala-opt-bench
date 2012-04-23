package benchmarks.primbox

import benchmarks.Benchmark

class BoxToDouble extends Benchmark {
  val a = new Array[Double](1000);
  override def name = "box-to-double"
  override def run() = {
    super.run
    var s: Long = 0;
    val t1 = System.nanoTime
    for (t <- 0 to 10000) {
      var i = 0;
      while (i < a.length) {
        a(i) = java.lang.Double.longBitsToDouble(i);
        i = i + 1
      }

      i = 0;
      while (i < a.length) {
        s = s + java.lang.Double.doubleToRawLongBits(a(i));
        i = i + 1
      }
    }
    log(""+s);
  }
}