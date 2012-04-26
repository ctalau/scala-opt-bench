package instrument

object Main {

  def main(args: Array[String]) {
    var c = 0
    def f(x: Int) = { c = 3 }
    def f1(y: Int) = { c = 4 }

    for (i <- 1 to 10000) (new Smth).g(f1)
    for (i <- 1 to 10000) (new Smth).g(f)

  }
}

class Smth {
  var cnt = 0
  def g(f: Int => Unit) = { Instrument.getCode }
}