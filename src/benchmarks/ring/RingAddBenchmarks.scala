package benchmarks.ring

import benchmarks.Benchmark
import benchmarks.arrayops.Conversions._

/**
 * Miniboxed
 */
class RingSpBooleanAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpBoolean = new RingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, BooleanToLong(data(i))); i += 1 }
    total
    //log("" + LongToBoolean(total))
  }
}
class RingSpIntAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpInt = new RingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, IntToLong(data(i))); i += 1 }
    total
    //log("" + LongToInt(total))
  }
}
class RingSpDoubleAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpDouble = new RingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, DoubleToLong(data(i))); i += 1 }
    total
    //log("" + LongToDouble(total))
  }
}

/**
 * Raw
 */
class RawRingSpBooleanAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpBoolean = new RawRingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}
class RawRingSpIntAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpInt = new RawRingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}
class RawRingSpDoubleAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpDouble = new RawRingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}

/**
 * Boxed version
 */
class BoxedRingSpBooleanAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpBoolean = new BoxedRingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}

class BoxedRingSpIntAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpInt = new BoxedRingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}
class BoxedRingSpDoubleAddBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpDouble = new BoxedRingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    while (i < len) { total = ring.plus(total, data(i)); i += 1 }
    total
    //log("" + total)
  }
}
