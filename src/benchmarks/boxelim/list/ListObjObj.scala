package benchmarks.boxelim.list

import benchmarks.Benchmark

class ListObjObj extends ListBase with Benchmark {

  override def name = "list-obj-obj"
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

  def build(n: Int): ListObj= {
    var xs: ListObj = null
    for (i <- 1 to n) {
      xs = ListObj(new Integer(i), xs)
    }
    xs
  }

  def sum(l: ListObj): Int = {
    var xs = l
    var s = 0
    while (xs != null) {
      s = s + xs.hd.asInstanceOf[Int]
      xs = xs.tl
    }
    s
  }
}

object ListObj {
  def apply(hd: Any, tl : ListObj) = {
    val l = new ListObj(); 
    l.hd = hd
    l.tl = tl
    l
  }
}
class ListObj { 
  var hd : Any = _
  var tl : ListObj = null
  
  @inline
  final def map(f : Any => Any) : ListObj = {
    if (tl == null)
      ListObj(f(hd), null)
    else
      ListObj(f(hd), tl.map(f))
  }
}


