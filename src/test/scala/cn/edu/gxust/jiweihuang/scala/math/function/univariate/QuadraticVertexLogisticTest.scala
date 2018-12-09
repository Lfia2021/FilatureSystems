package cn.edu.gxust.jiweihuang.scala.math.function.univariate

import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class QuadraticVertexLogisticTest extends UnitSpec {
  "" should "" in {
    println(QuadraticVertexLogistic(1e-2,1200,0,1,0.005,300,1.5).integrateRomberg(0, 1000))
    println(QuadraticVertexLogistic(1e-2,1200,0,1,0.005,300,1.5).integrateSimpson(0, 1000))
    println(QuadraticVertexLogistic(1e-2,1200,0,1,0.005,300,1.5).integrateTrapezoid(0, 1000))
    println(QuadraticVertexLogistic(1e-2,1200,0,1,0.005,300,1.5).integrateMidPoint(0, 1000))
    println(QuadraticVertexLogistic(1e-2,1200,0,1,0.005,300,1.5).integrateIterativeLegendreGauss(0, 1000))
  }

  "f" should "g" in {
    println(QuadraticVertexLogistic(3).differential(1))
    println(QuadraticVertexLogistic(3).derivative(1))
    println(QuadraticVertexLogistic(4, 5).differential(2))
    println(QuadraticVertexLogistic(4, 5).derivative(2))
    println(QuadraticVertexLogistic(4, 5, 6, 7).differential(3))
    println(QuadraticVertexLogistic(4, 5, 6, 7).derivative(3))
    println(QuadraticVertexLogistic(8, 9, 10, 11, 0, 2, 3).differential(4))
    println(QuadraticVertexLogistic(8, 9, 10, 11, 0, 2, 3).derivative(4))
  }
}
