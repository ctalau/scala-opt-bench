package benchmarks.ring

import benchmarks.arrayops.Conversions._

trait Ring[A] {
  def zero:A
  def one:A
  def negate(a:A):A
  def plus(a:A, b:A):A
  def times(a:A, b:A):A
  def minus(a:A, b:A):A = plus(a, negate(b))
}

trait RingSp {
  def zero:Long
  def one:Long
  def negate(a:Long):Long
  def plus(a:Long, b:Long):Long
  def times(a:Long, b:Long):Long
  // minus function is inherited from the trait
  def minus(a:Long, b:Long):Long = plus(a, negate(b))
}

/**
 * minispec'd classes
 */
class RingSpBoolean {
  private def _zero: Boolean = false
  private def _one:Boolean = true
  private def _negate(a:Boolean):Boolean = !a   
  private def _plus(a:Boolean, b:Boolean):Boolean = a ^ b
  private def _times(a:Boolean, b:Boolean):Boolean = a && b 
  def zero:Long = 
    BooleanToLong(_zero)
  def one:Long = 
    BooleanToLong(_one)
  def negate(a:Long):Long = 
    BooleanToLong(_negate(LongToBoolean(a)))
  def plus(a:Long, b:Long):Long = 
    BooleanToLong(_plus(LongToBoolean(a), LongToBoolean(b)))
  def times(a:Long, b:Long):Long = 
    BooleanToLong(_times(LongToBoolean(a), LongToBoolean(b)))
  def minus(a:Long, b:Long):Long = plus(a, negate(b))

}
class RingSpInt {
  private def _zero: Int = 0
  private def _one:Int = 1
  private def _negate(a:Int):Int = -a   
  private def _plus(a:Int, b:Int):Int = a + b
  private def _times(a:Int, b:Int):Int = a * b
  def zero:Long = 
    IntToLong(_zero)
  def one:Long = 
    IntToLong(_one)
  def negate(a:Long):Long = 
    IntToLong(_negate(LongToInt(a)))
  def plus(a:Long, b:Long):Long = 
    IntToLong(_plus(LongToInt(a), LongToInt(b)))
  def times(a:Long, b:Long):Long = 
    IntToLong(_times(LongToInt(a), LongToInt(b)))
  def minus(a:Long, b:Long):Long = plus(a, negate(b))
}
class RingSpDouble {
  private def _zero: Double = 0d
  private def _one:Double = 1d
  private def _negate(a:Double):Double = -a   
  private def _plus(a:Double, b:Double):Double = a + b
  private def _times(a:Double, b:Double):Double = a * b
  def zero:Long = 
    DoubleToLong(_zero)
  def one:Long = 
    DoubleToLong(_one)
  def negate(a:Long):Long = 
    DoubleToLong(_negate(LongToDouble(a)))
  def plus(a:Long, b:Long):Long = 
    DoubleToLong(_plus(LongToDouble(a), LongToDouble(b)))
  def times(a:Long, b:Long):Long = 
    DoubleToLong(_times(LongToDouble(a), LongToDouble(b)))
  def minus(a:Long, b:Long):Long = plus(a, negate(b))
}


class BoxedRingSpBoolean {
  private def _zero: Boolean = false
  private def _one:Boolean = true
  private def _negate(a:Boolean):Boolean = !a   
  private def _plus(a:Boolean, b:Boolean):Boolean = a ^ b
  private def _times(a:Boolean, b:Boolean):Boolean = a && b 
  def zero:Any = 
    BooleanToAny(_zero)
  def one:Any = 
    BooleanToAny(_one)
  def negate(a:Any):Any = 
    BooleanToAny(_negate(AnyToBoolean(a)))
  def plus(a:Any, b:Any):Any = 
    BooleanToAny(_plus(AnyToBoolean(a), AnyToBoolean(b)))
  def times(a:Any, b:Any):Any = 
    BooleanToAny(_times(AnyToBoolean(a), AnyToBoolean(b)))
   def minus(a:Any, b:Any):Any = plus(a, negate(b))
}
class BoxedRingSpInt {
  private def _zero: Int = 0
  private def _one:Int = 1
  private def _negate(a:Int):Int = -a   
  private def _plus(a:Int, b:Int):Int = a + b
  private def _times(a:Int, b:Int):Int = a * b
  def zero:Any = 
    IntToAny(_zero)
  def one:Any = 
    IntToAny(_one)
  def negate(a:Any):Any = 
    IntToAny(_negate(AnyToInt(a)))
  def plus(a:Any, b:Any):Any = 
    IntToAny(_plus(AnyToInt(a), AnyToInt(b)))
  def times(a:Any, b:Any):Any = 
    IntToAny(_times(AnyToInt(a), AnyToInt(b)))
   def minus(a:Any, b:Any):Any = plus(a, negate(b))
}
class BoxedRingSpDouble {
  private def _zero: Double = 0d
  private def _one:Double = 1d
  private def _negate(a:Double):Double = -a   
  private def _plus(a:Double, b:Double):Double = a + b
  private def _times(a:Double, b:Double):Double = a * b
  def zero:Any = 
    DoubleToAny(_zero)
  def one:Any = 
    DoubleToAny(_one)
  def negate(a:Any):Any = 
    DoubleToAny(_negate(AnyToDouble(a)))
  def plus(a:Any, b:Any):Any = 
    DoubleToAny(_plus(AnyToDouble(a), AnyToDouble(b)))
  def times(a:Any, b:Any):Any = 
    DoubleToAny(_times(AnyToDouble(a), AnyToDouble(b)))
   def minus(a:Any, b:Any):Any = plus(a, negate(b))
}

/**
 * Raw versions
 */
class RawRingSpBoolean {
   def zero: Boolean = false
   def one:Boolean = true
   def negate(a:Boolean):Boolean = !a   
   def plus(a:Boolean, b:Boolean):Boolean = a ^ b
   def times(a:Boolean, b:Boolean):Boolean = a && b
   def minus(a:Boolean, b:Boolean):Boolean = plus(a, negate(b))
}
class RawRingSpInt {
   def zero: Int = 0
   def one:Int = 1
   def negate(a:Int):Int = -a   
   def plus(a:Int, b:Int):Int = a + b
   def times(a:Int, b:Int):Int = a * b
   def minus(a:Int, b:Int):Int = plus(a, negate(b))
}
class RawRingSpDouble {
   def zero: Double = 0
   def one:Double = 1
   def negate(a:Double):Double = -a   
   def plus(a:Double, b:Double):Double = a + b
   def times(a:Double, b:Double):Double = a * b
   def minus(a:Double, b:Double):Double = plus(a, negate(b))
}
