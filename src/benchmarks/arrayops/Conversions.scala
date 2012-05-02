package benchmarks.arrayops

object Conversions {
  @inline final def LongToDouble(l : Long) : Double = java.lang.Double.longBitsToDouble(l) 
  @inline final def DoubleToLong(d: Double) : Long = java.lang.Double.doubleToLongBits(d)

  @inline final def LongToBoolean(l : Long): Boolean = (l.toInt != 0)
  @inline final def BooleanToLong(b : Boolean): Long = if (b) 1 else 0
  
  @inline final def LongToUnit(l : Long): Unit = ()
  @inline final def UnitToLong(u : Unit): Long = 0
  
  @inline final def LongToInt(l : Long): Int = l.toInt
  @inline final def IntToLong(i : Int): Long = i.toLong

  
  
  @inline final def AnyToDouble(l : Any) : Double = l.asInstanceOf[Double] 
  @inline final def DoubleToAny(d: Double) : Any = d
  
  @inline final def AnyToBoolean(l : Any): Boolean = l.asInstanceOf[Boolean]
  @inline final def BooleanToAny(b : Boolean): Any = b
  
  @inline final def AnyToUnit(l : Any): Unit = l.asInstanceOf[Unit]
  @inline final def UnitToAny(u : Unit): Any = u
  
  @inline final def AnyToInt(l : Any): Int = l.asInstanceOf[Int]
  @inline final def IntToAny(i : Int): Any = i //new Integer(i)

}

