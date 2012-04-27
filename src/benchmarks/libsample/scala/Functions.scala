package scala

trait Function0[@specialized +R] {
  def apply():R
}


trait Function1[@specialized -T,@specialized  +R] {
  def apply(x: T):R
}

trait Function2[@specialized -T1,@specialized  -T2,@specialized +R] {
  def apply(x: T1, y: T2):R
}

case class Tuple2[@specialized T,@specialized  U](x : T, y: U) {
  def _1():T = x
  def _2():U = y
}