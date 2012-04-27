package benchmarks.arrayops

import benchmarks.ComparingBenchmark

object cst {
  def size = 200
  def T = 50000000
}


object ClassTags {
    final val UNIT    : Byte = 0
    final val BOOLEAN : Byte = 1
    final val BYTE    : Byte = 2
    final val CHAR    : Byte = 3
    final val SHORT   : Byte = 4
    final val INT     : Byte = 5
    final val LONG    : Byte = 6
    final val FLOAT   : Byte = 7
    final val DOUBLE  : Byte = 8
  }
  
/**
 * Different implementations for array operations
 */
object MainArrayOps {

  def main(args: Array[String]) {
    import ClassTags._
  
/*    val comp = new ComparingBenchmark(
      List(
          new BoxedArrayDoubleRunner(),
          
          new RawArrayBooleanRunner(),
          new RawArrayIntRunner(),
          new RawArrayDoubleRunner(),

          new SpecializedArrayBooleanRunner(),
          new SpecializedArrayIntRunner(),
          new SpecializedArrayDoubleRunner(),
          
//          new SnippetArray(SnippetBoolean),
//          new SnippetArray(SnippetInt),
//          new SnippetArray(SnippetDouble),
          
          new SwitchClassTagBooleanRunner,
          new SwitchClassTagArrayIntRunner,
          new SwitchClassTagArrayDoubleRunner

//          new IfClassTagsArray(BOOLEAN),
//          new IfClassTagsArray(INT),
//          new IfClassTagsArray(DOUBLE)
          ))
    comp.iter = 7
    comp.run()
*/
  for (i <- 1 to 1000) {
    val l = scala.util.Random.nextLong
  }  
  
  }
}