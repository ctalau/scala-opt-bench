package benchmarks.libsample.scala.collection.mutable

import benchmarks.libsample.scala.collection.generic.Growable
import benchmarks.libsample.scala.collection.TraversableLike
import benchmarks.libsample.scala.collection.immutable._
import benchmarks.libsample.scala.collection.generic.CanBuildFrom

trait Builder[-Elem, +To] extends Growable[Elem] {
  def +=(elem: Elem): this.type
  def clear()
  def result(): To
  def sizeHint(size: Int) {}
  
  def mapResult[NewTo](f: To => NewTo): Builder[Elem, NewTo] =
    new Builder[Elem, NewTo] with Proxy {
      val self = Builder.this
      def +=(x: Elem): this.type = { self += x; this }
      def clear() = self.clear()
      override def ++=(xs: List[Elem]): this.type = { self ++= xs; this }
      def result: NewTo = f(self.result)
    }
}


