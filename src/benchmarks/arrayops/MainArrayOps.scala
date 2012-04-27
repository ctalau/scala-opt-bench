package benchmarks.arrayops

import benchmarks.ComparingBenchmark

object cst {
  def size = 2000
  def T = 20000
}


object ClassTags {
    final val UNIT = 0
    final val BOOLEAN = 1
    final val BYTE = 2
    final val CHAR = 3
    final val SHORT = 4
    final val INT = 5
    final val LONG = 6
    final val FLOAT = 7
    final val DOUBLE = 8
  }
  
/**
 * Different implementations for array operations
 */
object MainArrayOps {

  def main(args: Array[String]) {
    import ClassTags._
    
    val comp = new ComparingBenchmark(
      List(
          new BoxedArrayDouble(),
          
          new RawArrayBoolean(),
          new RawArrayInt(),
          new RawArrayDouble(),

          new SpecializedArrayBoolean(),
          new SpecializedArrayInt(),
          new SpecializedArrayDouble(),
          
          new SnippetArray(SnippetBoolean),
          new SnippetArray(SnippetInt),
          new SnippetArray(SnippetDouble),
          
          new SwitchClassTagsArray(BOOLEAN),
          new SwitchClassTagsArray(INT),
          new SwitchClassTagsArray(DOUBLE),

          new IfClassTagsArray(BOOLEAN),
          new IfClassTagsArray(INT),
          new IfClassTagsArray(DOUBLE)
          ))
    comp.iter = 7
    comp.run()

  }
}