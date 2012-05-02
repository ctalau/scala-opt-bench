package benchmarks.ring

import benchmarks.Benchmark
import benchmarks.arrayops.Conversions._

/**
 * Miniboxed
 */
class RingSpBooleanSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpBoolean = new RingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = LongToBoolean(ring.zero)
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = LongToBoolean(ring.minus(BooleanToLong(total), BooleanToLong(data(i)))); i += 1 };  j += 1}
    total
    log("" + (total))
  }
}
class RingSpIntSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpInt = new RingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = LongToInt(ring.zero)
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = LongToInt(ring.minus(IntToLong(total), IntToLong(data(i)))); i += 1 };  j += 1}
    total
    log("" + (total))
  }
}
class RingSpDoubleSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RingSpDouble = new RingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = LongToDouble(ring.zero)
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = LongToDouble(ring.minus(DoubleToLong(total), DoubleToLong(data(i)))); i += 1 };  j += 1}
    total
    log("" + (total))
  }

}

/**
 * Raw
 */
class RawRingSpBooleanSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpBoolean = new RawRingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = ring.minus(total, data(i)); i += 1 };  j += 1}
    total
    log("" + total)
  }
}
class RawRingSpIntSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpInt = new RawRingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = ring.minus(total, data(i)); i += 1 };  j += 1}
    total
    log("" + total)
  }
}
class RawRingSpDoubleSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : RawRingSpDouble = new RawRingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = ring.minus(total, data(i)); i += 1 };  j += 1}
    total
    log("" + total)
  }
}

/**
 * Boxed version
 */
class BoxedRingSpBooleanSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpBoolean = new BoxedRingSpBoolean
  val data : Array[Boolean] = RingBenchmarks.booleans
  
  override def run() = {
    var total = AnyToBoolean(ring.zero)
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = AnyToBoolean(ring.minus(total, data(i))); i += 1 };  j += 1}
    total
    log("" + total)
  }
}

class BoxedRingSpIntSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpInt = new BoxedRingSpInt
  val data : Array[Int] = RingBenchmarks.ints
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = ring.minus(total, data(i)); i += 1 };  j += 1}
    total
    log("" + total)
  }
}
class BoxedRingSpDoubleSubtractBenchmark extends Benchmark {
  override def name = this.getClass.getName
  val ring : BoxedRingSpDouble = new BoxedRingSpDouble
  val data : Array[Double] = RingBenchmarks.doubles
  
  override def run() = {
    var total = ring.zero
    var i = 0
    val len = data.length
    var j = 0; while(j < 20000) { while (i < len) { total = ring.minus(total, data(i)); i += 1 };  j += 1}
    total
    log("" + total)
  }
}
