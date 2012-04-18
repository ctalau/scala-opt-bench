package benchmarks.boxelim

import benchmarks.ComparingBenchmark

/**
 * We explore a new kind of specialization for generic classes with 
 * primitive type arguments. 
 * 
 * The generic type parameters appear both in method parameter and in
 * field type (e.g. var a : T, var b : Array[T]). If we want to 
 * specialize method signatures, the number of methods in the class
 * will finally blow up (see current approach). 
 * 
 * If only the internal representation of fields is specialized, and 
 * the method signature is still generic (erased to Any), we obtain 
 * a performance similar to the case where both internal representation
 * and method signatures are specialized. 
 * 
 * One possible reason for this may be that compiler inlines the generic methods
 * and 
 * 
 * val a : Int = 0
 * setElem(box(a))
 * ...
 * setElem(e : Any) = { elem = unbox(a) }
 * 
 * becomes:
 * 
 * val a : Int = 0
 * val tmp = box(a)
 * elem = unbox(tmp)
 * 
 * and a simple peephole optimization will remove the box/unbox pair (or the escape
 * analysis will allocate tmp on the stack).
 */
object Main {
  def main(args: Array[String]) {
      val comp = new ComparingBenchmark(
          List(
              new VectorIntInt(), 
              new VectorObjObj(), 
              new VectorIntObj()))
      comp.run()
  }
  
}