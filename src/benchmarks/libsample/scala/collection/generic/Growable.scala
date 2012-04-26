
package benchmarks.libsample.scala.collection.generic
import benchmarks.libsample.scala.collection.immutable._

trait Growable[-A] {
  def +=(elem: A): this.type
  def ++=(xs: List[A]): this.type = { xs foreach += ; this }
  def clear()
}
