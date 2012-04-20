package benchmarks.boxelim.list

import benchmarks.Benchmark

class ListIntInt extends ListBase with Benchmark {

  override def name = "list-int-int"
  override def run() = {
    super.run
    var l = build(L)
    var s = 0
    for (i <- 1 to T) {
      l = l.map(x => x.asInstanceOf[Int] + 1)
      s = s + sum(l)
    }
    log("" + s)
  }

  def build(n: Int): ListIntI = {
    var xs: ListIntI = null
    for (i <- 1 to n) {
      xs = ListIntI(i, xs)
    }
    xs
  }

  def sum(l: ListIntI): Int = {
    var xs = l
    var s = 0
    while (xs != null) {
      s = s + xs.hd.asInstanceOf[Int]
      xs = xs.tl
    }
    s
  }
}

object ListIntI {
  def apply(hd: Int, tl: ListIntI) = {
    val l = new ListIntI();
    l.hd = hd
    l.tl = tl
    l
  }
}

class ListIntI {
  var hd: Int = _
  var tl: ListIntI = _


  def map(f: Any => Any): ListIntI = {
    var cl = this;
    var l = ListIntI(f(cl.hd).asInstanceOf[Int], null)
    cl = cl.tl
    val nl = l
 
    while (cl != null) {
      l.tl = ListIntI(f(cl.hd).asInstanceOf[Int], null)
      l = l.tl
      cl = cl.tl
    }
    nl
  }
}


