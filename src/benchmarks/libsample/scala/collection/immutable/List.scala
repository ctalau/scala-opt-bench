package benchmarks.libsample.scala.collection
package immutable

import benchmarks.libsample.scala.collection.mutable.ListBuffer
import benchmarks.libsample.scala.collection.generic.Growable
import benchmarks.libsample.scala.collection.LinearSeqOptimized
import benchmarks.libsample.scala.collection.mutable.Builder
import benchmarks.libsample.scala.collection.generic.CanBuildFrom

sealed abstract class List[+A] extends TraversableLike[A, List[A]]
  with LinearSeqOptimized[A, List[A]] with IterableLike[A, List[A]] {
  def isEmpty: Boolean
  def head: A
  def tail: List[A]

  def iterator: Iterator[A] = new Iterator[A] {
    var cursor = List.this
    override def hasNext = !isEmpty
    override def next = { val ret = cursor.head; cursor = cursor.tail; ret }
  }

  def ::[B >: A](x: B): List[B] =
    new immutable.::(x, this)

  def :::[B >: A](prefix: List[B]): List[B] =
    if (isEmpty) prefix
    else if (prefix.isEmpty) this
    else (new ListBuffer[B] ++= prefix).prependToList(this)

  def ++[B >: A, That](that: List[B]): That = {
    (this ::: that).asInstanceOf[That]
  }
  //
  //  def map[B](f: A => B): List[B] = {
  //    super.map[B, List[B]](f)(new List.ListCanBuildFrom[A, B]())
  //  }
}

case object Nil extends List[Nothing] {
  override def isEmpty = true
  override def head: Nothing = null.asInstanceOf[Nothing]
  override def tail: List[Nothing] = null

  // Removal of equals method here might lead to an infinite recursion similar to IntMap.equals.
  override def equals(that: Any) = that match {
    case that1: List[_] => that1.isEmpty
    case _ => false
  }
}

final case class ::[B](private var hd: B, private[collection] var tl: List[B]) extends List[B] {
  override def head: B = hd
  override def tail: List[B] = tl
  override def isEmpty: Boolean = false
}

object List {
  def empty[A]: List[A] = Nil
  def apply[A](xs: A*): List[A] = {
    xs.foldRight[List[A]](Nil)({ case (x, l) => x :: l })
  }

  implicit def canBuildFrom[A, T]: CanBuildFrom[List[T], A, List[A]] =
    new CanBuildFrom[List[T], A, List[A]] {
      override def apply(from: List[T]) = apply
      override def apply() = new Builder[A, List[A]] {
        var lb = new ListBuffer[A]()
        override def +=(elem: A) = {
          lb ++= List(elem); this
        }
        override def clear(): Unit = lb = new ListBuffer[A]()
        override def result() = lb.prependToList(Nil)
      }
    }
}


