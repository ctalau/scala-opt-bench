package benchmarks.boxelim.list

import benchmarks.Benchmark

class ListObjInt extends ListBase with Benchmark {

  override def name = "list-obj-int"
  override def run() = {
    super.run
    var l = build(L)
    var s = 0
    for (i <- 1 to T) {
      l = l.map(x => new Integer(x.asInstanceOf[Int] + 1))
      s = s + sum(l)
    }
    log("" + s)
  }

  def build(n: Int): ListInt = {
    var xs: ListInt = null
    for (i <- 1 to n) {
      xs = ListInt(new Integer(i), xs)
    }
    xs
  }

  def sum(l: ListInt): Int = {
    var xs = l
    var s = 0
    while (xs != null) {
      s = s + xs.hd.asInstanceOf[Int]
      xs = xs.tl
    }
    s
  }
}

object ListInt {
  def apply(_hd: Any, tl: ListInt) = {
    val hd = _hd.asInstanceOf[Int] 
    val l = new ListInt();
    l.hd = hd
    l.tl = tl
    l
  }
}

class ListInt {
  var hd: Int = _
  var tl: ListInt = _

  @inline
  final def map(f: Any => Any): ListInt = {
    if (tl == null)
      ListInt(f(new Integer(hd)).asInstanceOf[Int], null)
    else
      ListInt(f(new Integer(hd)).asInstanceOf[Int], tl.map(f))
  }
}


