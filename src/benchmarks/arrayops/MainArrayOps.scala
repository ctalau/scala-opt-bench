package benchmarks.arrayops

import benchmarks.ComparingBenchmark

object cst {
  def size = 200000
  def T = 200
}

/**
 * Different implementations for array operations
 */
object MainArrayOps {

  def main(args: Array[String]) {
    import ClassTags._
    val l = List(1,2)
    l foreach println
    val comp = new ComparingBenchmark(
      List(
        new BoxedArrayDoubleRunner(),

        new RawArrayBooleanRunner(),
        new RawArrayIntRunner(),
        new RawArrayDoubleRunner(),

        new SpecializedArrayBooleanRunner(),
        new SpecializedArrayIntRunner(),
        new SpecializedArrayDoubleRunner(),

        new DupSpecializedArrayBooleanRunner(),
        new DupSpecializedArrayIntRunner(),
        new DupSpecializedArrayDoubleRunner()

        //          new SnippetArray(SnippetBoolean),
        //          new SnippetArray(SnippetInt),
        //          new SnippetArray(SnippetDouble),

//        new SwitchClassTagArrayBooleanRunner,
//        new SwitchClassTagArrayIntRunner,
//        new SwitchClassTagArrayDoubleRunner,

//        new SpecSwitchClassTagArrayBooleanRunner,
//        new SpecSwitchClassTagArrayIntRunner,
//        new SpecSwitchClassTagArrayDoubleRunner 
        //          new IfClassTagsArray(BOOLEAN),
        //          new IfClassTagsArray(INT),
        //          new IfClassTagsArray(DOUBLE)
        ))
    comp.run()

  }
}