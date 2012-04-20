package benchmarks.boxelim

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
 * One possible reason for this may be that compiler inlines the generic 
 * methods and 
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
 * and a simple peephole optimization will remove the box/unbox pair (or the 
 * escape analysis will allocate tmp on the stack).
 * 
 * 
 * The parameters of a generic method are immediately unboxed, to make the 
 * boxed version short-lived after inlining. When calling a generic method, 
 * the arguments are boxed via 'new Integer(_)'. Integer.valueOf, while 
 * good for caching, will not allow stack allocation of the boxed version.
 * 
 */
class Placeholder {

}