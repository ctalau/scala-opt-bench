package benchmarks.arrayops

object Conversions {
  final def LongToDouble(l : Long) : Double = java.lang.Double.longBitsToDouble(l) 
  final def DoubleToLong(d: Double) : Long = java.lang.Double.doubleToRawLongBits(d)
  
  final def BooleanToLong(b : Boolean): Long = if (b) 0 else 1
  final def LongToBoolean(l : Long): Boolean = (l != 0)
  
  final def UnitToLong(u : Unit): Long = 0
  final def LongToUnit(l : Long): Unit = ()
  
}