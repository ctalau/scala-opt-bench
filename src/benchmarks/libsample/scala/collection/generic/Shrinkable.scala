package benchmarks.libsample.scala.collection.generic
import benchmarks.libsample.scala.collection.immutable._

trait Shrinkable[-A] {
  def --(): this.type
  def -=(elem: A): this.type = --
}




