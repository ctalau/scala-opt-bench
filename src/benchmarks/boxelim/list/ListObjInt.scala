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
    l.hd = new Integer(hd)
    l.tl = tl
    l
  }
}

/**
 * If the map is implemented recursively, nothing is inlined => bad performance
 */
class ListInt {
  private var _hd: Int = _
  var tl: ListInt = _

  def hd: Any = new Integer(_hd)
  def hd_=(v: Any) = { _hd = v.asInstanceOf[Int] }

  def map(f: Any => Any): ListInt = {
    var cl = this;
    var l = ListInt(f(cl.hd), null)
    cl = cl.tl
    val nl = l
 
    while (cl != null) {
      l.tl = ListInt(f(cl.hd), null)
      l = l.tl
      cl = cl.tl
    }
    nl
  }

}


