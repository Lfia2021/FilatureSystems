package cn.edu.gxust.jiweihuang.scala.math.function.univariate

trait TUnivariateIntegralFunction extends TUnivariateFunction {
  //val integralConstant = 0.0
  def integrate(x: Double): Double

  //definite integration
  def integrate(lowerX: Double, upperX: Double): Double =
    integrate(upperX) - integrate(lowerX)
}
