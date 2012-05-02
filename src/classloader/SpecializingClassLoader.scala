package classloader

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.lang.{ClassLoader => JClassLoader}
import java.util.{List => JList}
import java.util.ListIterator
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import scala.collection.JavaConverters.asScalaBufferConverter

class SpecializingClassLoader(parent: JClassLoader) extends JClassLoader(parent) {
  def this() = { this(null) }

  import SpecializingClassLoader._

  private final val SPEC_MARKER = "0sp0"

  override def loadClass(name: String): Class[_] = loadClass(name, false)

  private val definedClasses = Map[String, Class[_]]()

  override def loadClass(name: String, resolve: Boolean): Class[_] = {
    var classBytes: Array[Byte] = null
    if (name.startsWith("java")) {
      return super.loadClass(name, resolve)
    } else {
      // Read the template class file
      val in = classAsStream(name)
      val cr = new ClassReader(in);
      val classNode = new ClassNode();
      cr.accept(classNode, 0);

      val fieldNodes = classNode.fields.asInstanceOf[JList[FieldNode]].asScala
      for (fieldNode <- fieldNodes) {
        if (fieldNode.name.startsWith("tag_")) {
          fieldNode.access |= Opcodes.ACC_STATIC;
          fieldNode.value = new Integer(17)
        }
      }

      //Let's move through all the methods
      val methodNodes = classNode.methods.asInstanceOf[JList[MethodNode]].asScala
      for (methodNode <- methodNodes) {
        val insnNodes = methodNode.instructions.iterator().asInstanceOf[ListIterator[AbstractInsnNode]]

        while (insnNodes.hasNext) {
          val insn = insnNodes.next.asInstanceOf[AbstractInsnNode]

          if (insn.getOpcode == Opcodes.GETFIELD || insn.getOpcode == Opcodes.PUTFIELD) {
            val finsn = insn.asInstanceOf[FieldInsnNode]
            if (finsn.name.startsWith("tag_") /*&& finsn.owner == "test/LoggingTest"*/ ) {
              insn.getOpcode match {
                case Opcodes.GETFIELD =>
                  insnNodes.set(new InsnNode(Opcodes.POP));
                  insnNodes.add(new FieldInsnNode(Opcodes.GETSTATIC, finsn.owner, finsn.name, finsn.desc))
                case Opcodes.PUTFIELD =>
                  insnNodes.set(new InsnNode(Opcodes.POP2));
              }
            }
          }

          if (insn.getOpcode == Opcodes.NEW) {
            val tinsn = insn.asInstanceOf[TypeInsnNode]
            if (tinsn.desc.contains(SPEC_MARKER)) {
              //              tinsn.desc = tinsn.desc.replace("X", "13")
            }
          }

          if (insn.getOpcode == Opcodes.INVOKESPECIAL) {
            val minsn = insn.asInstanceOf[MethodInsnNode]
            if (minsn.name == "<init>" && minsn.owner.contains(SPEC_MARKER)) {
              val tag = insn.getPrevious.asInstanceOf[IntInsnNode]
              //              minsn.owner = minsn.owner.replace("X", "13")
            }
          }
        }
      }
      // Convert the class to byte array again
      val cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
      classNode.accept(cw);
      classBytes = cw.toByteArray
      // Load the class into the JVM
      val c = defineClass(name, classBytes, 0, classBytes.length)
      if (c == null)
        throw new ClassNotFoundException(name)
      if (resolve)
        resolveClass(c)

      c
    }

  }

  private def classAsStream(className: String) =
    getResourceAsStream(className.replaceAll("""\.""", "/") + ".class")

  private def readBytes(in: InputStream): Array[Byte] = {
    if (in == null)
      throw new ClassNotFoundException()
    val bos = new ByteArrayOutputStream();
    var next = in.read;
    while (next > -1) {
      bos.write(next);
      next = in.read();
    }
    bos.flush();
    bos.toByteArray();
  }

}

object SpecializingClassLoader {

  def setContext(cl: JClassLoader) =
    Thread.currentThread.setContextClassLoader(cl)

  final val TAG_FIELD_NAME_PREFIX = "_tag_"
  final val SPEC_CLASS_NAME_TEMPLATE = ".*Wmc.*Wsp"
  //  final val TAG_FIELD_NAME_PREFIX = "$tag$"
  //  final val SPEC_CLASS_NAME_TEMPLATE = "*$mc*$sp"
  private val descriptorToTag = Map(
    'U' -> 0,
    'Z' -> 1,
    'B' -> 2,
    'C' -> 3,
    'S' -> 4,
    'I' -> 5,
    'J' -> 6,
    'D' -> 7,
    'F' -> 8)

  private def getTypeTags(name: String) = {
    //    val typeParamDescriptors = name.substring(name.lastIndexOf('c') + 1, name.lastIndexOf('$')) 
    val typeParamDescriptors = name.substring(name.lastIndexOf('c') + 1, name.lastIndexOf('W'))
    typeParamDescriptors.map(descriptorToTag)
  }

  private def getTemplateName(name: String) = {
    val prefix = name.substring(0, name.lastIndexOf('c') + 1)

    //val params = name.substring(name.lastIndexOf('c') + 1, name.lastIndexOf('$'))
    val params = name.substring(name.lastIndexOf('c') + 1, name.lastIndexOf('W'))
    //val suffix = "$sp"
    val suffix = "Wsp"

    prefix + params.replaceAll(".", "X") + suffix
  }
}
