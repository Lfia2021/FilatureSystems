package cn.edu.gxust.jiweihuang.scala.math.function.univariate

import java.util

import cn.edu.gxust.jiweihuang.scala.math._
import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class QuadraticVertexTest extends UnitSpec {
  "QuadraticVertex constructor" should "throw new IllegalArgumentException if quadraticA == 0" in {
    assertThrows[IllegalArgumentException](QuadraticVertex(0, 1, 2))
    assertThrows[IllegalArgumentException](QuadraticVertex(0, 0, 2))
    assertThrows[IllegalArgumentException](QuadraticVertex(0, 1, 0))
    assertThrows[IllegalArgumentException](QuadraticVertex(0, 0, 0))
    assertThrows[IllegalArgumentException](QuadraticVertex(0))
    assertThrows[IllegalArgumentException](QuadraticVertex(0, 1))
    println(s"QuadraticVertex() = ${QuadraticVertex()}")
    println(s"QuadraticVertex(2) = ${QuadraticVertex(2)}")
    println(s"QuadraticVertex(3, 0) = ${QuadraticVertex(3, 0)}")
    println(s"QuadraticVertex(4, 1, 0) = ${QuadraticVertex(4, 1, 0)}")
  }

  "the vertex of QuadraticVertex" should "equals to right value" in {
    assertResult(Array[Double](0, 0))(QuadraticVertex().vertex)
    assertResult(Array[Double](2, 0))(QuadraticVertex(1, 2).vertex)
    assertResult(Array[Double](5, 3))(QuadraticVertex(2, 5, 3).vertex)
    assertResult(Array[Double](0, 5))(QuadraticVertex(3, 0, 5).vertex)
    assertResult(Array[Double](-3, 0))(QuadraticVertex(4, -3, 0).vertex)
    assertResult(Array[Double](1, 8))(QuadraticVertex(5, 1, 8).vertex)
    println(s"QuadraticVertex().vertex = ${util.Arrays.toString(QuadraticVertex().vertex)}")
    println(s"QuadraticVertex(1, 2).vertex = ${util.Arrays.toString(QuadraticVertex(1, 2).vertex)}")
    println(s"QuadraticVertex(2, 5, 3).vertex = ${util.Arrays.toString(QuadraticVertex(2, 5, 3).vertex)}")
    println(s"QuadraticVertex(3, 0, 5).vertex = ${util.Arrays.toString(QuadraticVertex(3, 0, 5).vertex)}")
    println(s"QuadraticVertex(4, -3, 0).vertex = ${util.Arrays.toString(QuadraticVertex(4, -3, 0).vertex)}")
    println(s"QuadraticVertex(5, 1, 8).vertex = ${util.Arrays.toString(QuadraticVertex(5, 1, 8).vertex)}")
  }

  "the isInvert of QuadraticVertex" should "equals to right value" in {
    assertResult(false)(QuadraticVertex().isInvert)
    assertResult(true)(QuadraticVertex(-1).isInvert)
    assertResult(false)(QuadraticVertex(2).isInvert)
    assertResult(true)(QuadraticVertex(-2).isInvert)
  }

  "the xIntersection of QuadraticVertex" should "equals to right value" in {
    assertResult(Array[Double](0))(QuadraticVertex().xIntersection)
    println(s"QuadraticVertex().xIntersectionNum = ${QuadraticVertex().xIntersectionNum}")
    assertResult(Array[Double](2))(QuadraticVertex(1, 2).xIntersection)
    assertResult(Array[Double]())(QuadraticVertex(2, 0, 3).xIntersection)
    assertResult(Array[Double]())(QuadraticVertex(2, 3, 5).xIntersection)
    println(s"QuadraticVertex(2, 3, 5).xIntersectionNum = ${QuadraticVertex(2, 3, 5).xIntersectionNum}")
    assertResult(Array[Double]())(QuadraticVertex(2, 1, 8).xIntersection)
    assertResult(Array[Double](8))(QuadraticVertex(2, 8, 0).xIntersection)

    println(s"QuadraticVertex(2,1,-8).xIntersection = ${util.Arrays.toString(QuadraticVertex(2, 1, -8).xIntersection)}")
    assertResult(0.0)(QuadraticVertex(2, 1, -8).value(-1.0))
    assertResult(0.0)(QuadraticVertex(2, 1, -8).value(3.0))
    println(s"QuadraticVertex(2, 1, -8).xIntersectionNum=${QuadraticVertex(2, 1, -8).xIntersectionNum}")
    println(s"QuadraticVertex(2,3,-5).xIntersection = ${util.Arrays.toString(QuadraticVertex(2, 3, -5).xIntersection)}")
    assertResult(0.0 - QuadraticVertex(2, 3, -5).value(QuadraticVertex(2, 3, -5).xIntersection(0)) < DefaultNumericalPrecision)(true)
    assertResult(0.0 - QuadraticVertex(2, 3, -5).value(QuadraticVertex(2, 3, -5).xIntersection(1)) < DefaultNumericalPrecision)(true)
    println(s"QuadraticVertex(2,3,-5).xIntersectionNum=${QuadraticVertex(2, 3, -5).xIntersectionNum}")
  }

  "the yIntersection of QuadraticVertex" should "equals to right value" in {
    assertResult(0)(QuadraticVertex().yIntersection)
    println(s"QuadraticVertex().yIntersection = ${QuadraticVertex().yIntersection}")
    println(s"QuadraticVertex(1,2,3).yIntersection = ${QuadraticVertex(1, 2, 3).yIntersection}")
    println(s"QuadraticVertex(2,3,-5).yIntersection = ${QuadraticVertex(2, 3, -5).yIntersection}")

    println(s"QuadraticVertex(2,3,-5).inverse(0.0) = ${util.Arrays.toString(QuadraticVertex(2, 3, -5).inverse(0.0))}")
    println(s"QuadraticVertex(2,1,-8).inverse(0.0)= ${util.Arrays.toString(QuadraticVertex(2, 1, -8).inverse(0.0))}")
  }

  "the value of QuadraticVertex" should "equals to right value" in {
    println(s"QuadraticVertex().value(0) = ${QuadraticVertex().value(0)}")
    println(s"QuadraticVertex().value(1) = ${QuadraticVertex().value(1)}")
    println(s"QuadraticVertex().value(2) = ${QuadraticVertex().value(2)}")
  }

  "the derivative of QuadraticVertex" should "equals to right value" in {
    assertResult(QuadraticVertex(1, 2, 3).derivative(0))(QuadraticVertex(1, 2, 3).differential(0))
    assertResult(QuadraticVertex(1, 2, 3).derivative(1))(QuadraticVertex(1, 2, 3).differential(1))
    assertResult(QuadraticVertex(1, 2, 3).derivative(2))(QuadraticVertex(1, 2, 3).differential(2))
    assertResult(QuadraticVertex(1, 2, 3).derivative(3))(QuadraticVertex(1, 2, 3).differential(3))
    assertResult(QuadraticVertex(1, 2, 3).derivative(4))(QuadraticVertex(1, 2, 3).differential(4))
    assertResult(QuadraticVertex(1, 2, 3).derivative(5))(QuadraticVertex(1, 2, 3).differential(5))
    assertResult(QuadraticVertex(1, 2, 3).derivative(6))(QuadraticVertex(1, 2, 3).differential(6))
  }
  "the integrate of QuadraticVertex" should "equals to right value" in {
    println(s"QuadraticVertex(1, 2, 3).integrate(-20, 20) = ${QuadraticVertex(1, 2, 3).integrate(-20, 20)}")
    println(s"QuadraticVertex(1, 2, 3).integrateRomberg(-20, 20) = ${QuadraticVertex(1, 2, 3).integrateRomberg(-20, 20)}")
    println(s"QuadraticVertex(1, 2, 3).integrateSimpson(-20, 20) = ${QuadraticVertex(1, 2, 3).integrateSimpson(-20, 20)}")
    println(s"QuadraticVertex(1, 2, 3).integrateMidPoint(-20, 20)=${QuadraticVertex(1, 2, 3).integrateMidPoint(-20, 20)}")
    println(s"QuadraticVertex(1, 2, 3).integrateTrapezoid(-20, 20)=${QuadraticVertex(1, 2, 3).integrateTrapezoid(-20, 20)}")
    println(s"QuadraticVertex(1, 2, 3).integrateIterativeLegendreGauss(-20, 20)=${QuadraticVertex(1, 2, 3).integrateIterativeLegendreGauss(-20, 20)}")
  }
}
