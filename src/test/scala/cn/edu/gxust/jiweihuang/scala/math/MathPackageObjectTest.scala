package cn.edu.gxust.jiweihuang.scala.math

import cn.edu.gxust.jiweihuang.java.math.Math

object MathPackageObjectTest extends App {
  println(s"DefaultNumericalPrecision = $DefaultNumericalPrecision")
  println(s"Math.DefaultNumericalPrecision = ${Math.DefaultNumericalPrecision}")
  assert(DefaultNumericalPrecision == Math.DefaultNumericalPrecision)
}
