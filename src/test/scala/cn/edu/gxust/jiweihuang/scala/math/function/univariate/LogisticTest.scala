package cn.edu.gxust.jiweihuang.scala.math.function.univariate


import cn.edu.gxust.jiweihuang.scala.math._
import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class LogisticTest extends UnitSpec {
  "logisticExp" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticExp(2, 1, 2, 3))(TLogistic.logisticExp(1, 2, 3)(2.0))
    assertResult(ILogistic.logisticExp(2, 4, 5, 6))(TLogistic.logisticExp(4, 5, 6)(2.0))
    assertResult(ILogistic.logisticExp(2, 7, 8, 9))(TLogistic.logisticExp(7, 8, 9)(2.0))
    assertResult(ILogistic.logisticExp(2, -1, -2, -3))(TLogistic.logisticExp(-1, -2, -3)(2.0))
    assertResult(ILogistic.logisticExp(2, -4, -5, -6))(TLogistic.logisticExp(-4, -5, -6)(2.0))
    assertResult(ILogistic.logisticExp(2, -7, -8, -9))(TLogistic.logisticExp(-7, -8, -9)(2.0))
    println(s"ILogistic.logisticExp(2, 1, 2, 3) = ${ILogistic.logisticExp(2, 1, 2, 3)}")
    println(s"TLogistic.logisticExp(1, 2, 3)(2.0)= ${TLogistic.logisticExp(1, 2, 3)(2.0)}")
    println(s"ILogistic.logisticExp(2, 4, 5, 6) = ${ILogistic.logisticExp(2, 4, 5, 6)}")
    println(s"TLogistic.logisticExp(4, 5, 6)(2.0)= ${TLogistic.logisticExp(4, 5, 6)(2.0)}")
    println(s"ILogistic.logisticExp(2, 7, 8, 9) = ${ILogistic.logisticExp(2, 7, 8, 9)}")
    println(s"TLogistic.logisticExp(7, 8, 9)(2.0)= ${TLogistic.logisticExp(7, 8, 9)(2.0)}")

    println(s"ILogistic.logisticExp(2, -1, -2, -3) = ${ILogistic.logisticExp(2, -1, -2, -3)}")
    println(s"TLogistic.logisticExp(-1, -2, -3)(2.0)= ${TLogistic.logisticExp(-1, -2, -3)(2.0)}")
    println(s"ILogistic.logisticExp(2, -4, -5, -6) = ${ILogistic.logisticExp(2, -4, -5, -6)}")
    println(s"TLogistic.logisticExp(-4, -5, -6)(2.0)= ${TLogistic.logisticExp(-4, -5, -6)(2.0)}")
    println(s"ILogistic.logisticExp(2, -7, -8, -9) = ${ILogistic.logisticExp(2, -7, -8, -9)}")
    println(s"TLogistic.logisticExp(-7, -8, -9)(2.0)= ${TLogistic.logisticExp(-7, -8, -9)(2.0)}")
  }
  "logisticExpPlusOne" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticExpPlusOne(2, 1, 2, 3))(TLogistic.logisticExpPlusOne(1, 2, 3)(2.0))
    assertResult(ILogistic.logisticExpPlusOne(2, -1, -2, -3))(TLogistic.logisticExpPlusOne(-1, -2, -3)(2.0))
    assertResult(ILogistic.logisticExpPlusOne(2, 4, 5, 6))(TLogistic.logisticExpPlusOne(4, 5, 6)(2.0))
    assertResult(ILogistic.logisticExpPlusOne(2, -4, -5, -6))(TLogistic.logisticExpPlusOne(-4, -5, -6)(2.0))
  }
  "logistic" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logistic(2, -5, 4, 8))(TLogistic.logistic(-5, 4, 8)(2))
    assertResult(ILogistic.logistic(3, 7, 4, 8))(TLogistic.logistic(7, 4, 8)(3))
    assertResult(ILogistic.logistic(4, 2, -4, 8))(TLogistic.logistic(2, -4, 8)(4))
    assertResult(ILogistic.logistic(6, -5, 4, -8))(TLogistic.logistic(-5, 4, -8)(6))
  }
  "logisticDerivative" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticDerivative(2, 2, -9, 5))(TLogistic.logisticDerivative(2, -9, 5)(2))
    assertResult(ILogistic.logisticDerivative(-2, 2, -9.8, 5))(TLogistic.logisticDerivative(2, -9.8, 5)(-2))
    assertResult(ILogistic.logisticDerivative(-6.2, 2, -9, 5.3))(TLogistic.logisticDerivative(2, -9, 5.3)(-6.2))
    assertResult(ILogistic.logisticDerivative(5.3, 2.9, -9.5, 5))(TLogistic.logisticDerivative(2.9, -9.5, 5)(5.3))
    assertResult(ILogistic.logisticDerivative(3.2, 20, -9, 5.8))(TLogistic.logisticDerivative(20, -9, 5.8)(3.2))
    assertResult(ILogistic.logisticDerivative(1.2, -5.2, -8.9, 50))(TLogistic.logisticDerivative(-5.2, -8.9, 50)(1.2))
  }
  "logisticIntegrate" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticIntegrate(2, -5, 8, 3))(TLogistic.logisticIntegrate(-5, 8, 3)(2))
  }
  "logisticDerivativeM" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticDerivativeM(2.0, -9, 8, 2))(TLogistic.logisticDerivativeM(-9, 8, 2)(2))
  }
  "logisticDerivativeK" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticDerivativeK(2.0, -9, 8, 2))(TLogistic.logisticDerivativeK(-9, 8, 2)(2))
  }
  "logisticDerivativeX0" should "equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic
    assertResult(ILogistic.logisticDerivativeX0(2.0, -9, 8, 2))(TLogistic.logisticDerivativeX0(-9, 8, 2)(2))
  }
  "a Logistic constructor" should "throw new IllegalArgumentException if {logisticM = 0}" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate
    assertThrows[IllegalArgumentException] {
      TLogistic(0, 1, 2)
      TLogistic(0, 2, 3)
      TLogistic(0, 0, 3)
      TLogistic(0, 0, 0)
      TLogistic()
      new univariate.Logistic(0, 1, 2)
      new univariate.Logistic(0, 2, 3)
      new univariate.Logistic(0, 0, 3)
      new univariate.Logistic(0, 0, 0)
      new univariate.Logistic()
    }
  }

  "Logistic(1,2,3).formula" should "1.0 / (1 + exp(-2.0 * (x - 3.0)))" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate
    println(s"Logistic(1,2,3).formula = ${TLogistic(1, 2, 3).formula}")
    assertResult("1.0 / (1 + exp(-2.0 * (x - 3.0)))")(TLogistic(1, 2, 3).formula)
    println(s"Logistic(1,2,3).formula = ${new univariate.Logistic(1, 2, 3).formula}")

  }

  "Logistic.derivative" should "all equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate
    println(s"Logistic(1,2,3).derivative(2.0) = ${TLogistic(1, 2, 3).derivative(2.0)}")
    println(s"Logistic.logisticDerivative(1, 2, 3)(2) = ${TLogistic.logisticDerivative(1, 2, 3)(2)}")
    println(s"Logistic(1, 2, 3).differential(2.0) = ${TLogistic(1, 2, 3).differential(2.0)}")
    assert(TLogistic.logisticDerivative(1, 2, 3)(2) - TLogistic(1, 2, 3).derivative(2) < DefaultNumericalPrecision)
    assert(TLogistic(1, 2, 3).differential(2.0) - TLogistic(1, 2, 3).derivative(2.0) < DefaultNumericalPrecision)
    val logistic = TLogistic(1, 2, 3)
    val jlogistic = new univariate.Logistic(1, 2, 3)
    assert(logistic.derivative(0) - logistic.differential(0) <= DefaultNumericalPrecision)
    assert(logistic.derivative(100) - logistic.differential(100) <= DefaultNumericalPrecision)
    assert(logistic.derivative(-100) - logistic.differential(-100) <= DefaultNumericalPrecision)
    assert(logistic.derivative(200) - logistic.differential(200) <= DefaultNumericalPrecision)
    assert(logistic.derivative(-200) - logistic.differential(-200) <= DefaultNumericalPrecision)
    assert(logistic.derivative(10) - logistic.differential(10) <= DefaultNumericalPrecision)
    assert(logistic.derivative(5) - logistic.differential(5) <= DefaultNumericalPrecision)

    assertResult(logistic.derivative(100))(jlogistic.derivative(100))
    assertResult(logistic.differential(-100))(jlogistic.differential(-100))
  }

  "Logistic.integrate" should "all equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate
    println(s"Logistic(1,2,3).integrate(2)=${TLogistic(1, 2, 3).integrate(2)}")

    println(s"Logistic.logisticIntegrate(1,2,3)(2.0)=${TLogistic.logisticIntegrate(1, 2, 3)(2.0)}")

    assert(TLogistic(1, 2, 3).integrate(2) - TLogistic.logisticIntegrate(1, 2, 3)(2.0) < DefaultNumericalPrecision)

    println(s"Logistic(1, 2, 3).integrateRomberg(0, 1200) = ${TLogistic(1, 2, 3).integrateRomberg(0, 1200)}")
    println(s"Logistic(1, 2, 3).integrateSimpson(0, 1200)=${TLogistic(1, 2, 3).integrateSimpson(0, 1200)}")
    println(s"Logistic(1, 2, 3).integrateMidPoint(0, 1200) = ${TLogistic(1, 2, 3).integrateMidPoint(0, 1200)}")
    println(s"Logistic(1, 2, 3).integrateTrapezoid(0, 1200) = ${TLogistic(1, 2, 3).integrateTrapezoid(0, 1200)}")
    println(s"Logistic(1, 2, 3).integrateIterativeLegendreGauss(0, 1200) = ${TLogistic(1, 2, 3).integrateIterativeLegendreGauss(0, 1200)}")
    val logistic = TLogistic(1, 2, 3)
    val jlogistic = new univariate.Logistic(1, 2, 3)
    assertResult(logistic.integrateMidPoint(0, 100))(jlogistic.integrateMidPoint(0, 100))
    assertResult(logistic.integrateSimpson(0, 100))(jlogistic.integrateSimpson(0, 100))
    assertResult(logistic.integrateTrapezoid(0, 100))(jlogistic.integrateTrapezoid(0, 100))
    assertResult(logistic.integrateRomberg(0, 100))(jlogistic.integrateRomberg(0, 100))
    assertResult(logistic.integrateIterativeLegendreGauss(0, 100))(jlogistic.integrateIterativeLegendreGauss(0, 100))
  }

  "Logistic.value" should "all equals to right value" in {
    import cn.edu.gxust.jiweihuang.java.math.function.univariate
    println(s"Logistic(1,2,3).value(2)=${TLogistic(1, 2, 3).value(2)}")
    println(s"Logistic.logistic(1,2,3)(2)=${TLogistic.logistic(1, 2, 3)(2)}")
    assert(TLogistic(1, 2, 3).value(2) - TLogistic.logistic(1, 2, 3)(2) < DefaultNumericalPrecision)
    val logistic = TLogistic(1, 2, 3)
    val jlogistic = new univariate.Logistic(1, 2, 3)
    assertResult(logistic.value(2))(jlogistic.value(2))
    assertResult(logistic.value(0))(jlogistic.value(0))
    assertResult(logistic.value(-2))(jlogistic.value(-2))
    assertResult(logistic.value(10))(jlogistic.value(10))
    assertResult(logistic.value(100))(jlogistic.value(100))

  }
}
