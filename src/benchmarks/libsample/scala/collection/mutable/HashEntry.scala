package benchmarks.libsample.scala.collection.mutable

trait HashEntry [A, E] {
  val key: A
  var next: E = _
}
