package benchmarks.arrayops

object Conversions {
  @inline final def LongToDouble(l : Long) : Double = java.lang.Double.longBitsToDouble(l) 
  @inline final def DoubleToLong(d: Double) : Long = java.lang.Double.doubleToLongBits(d)
  
  @inline final def BooleanToLong(b : Boolean): Long = if (b) 0 else 1
  @inline final def LongToBoolean(l : Long): Boolean = (l != 0)
  
  @inline final def UnitToLong(u : Unit): Long = 0
  @inline final def LongToUnit(l : Long): Unit = ()
  
  @inline final def IntToLong(i : Int): Long = i.toLong
  @inline final def LongToInt(l : Long): Int = l.toInt

}