package cn.edu.gxust.jiweihuang.scala.math.fitter

import java.util

import cn.edu.gxust.jiweihuang.scala.math.function.univariate.Logistic
import cn.edu.gxust.jiweihuang.scala.test.UnitSpec
import org.hipparchus.fitting.WeightedObservedPoint

class LogisticFitterTest extends UnitSpec {
  "LogisticFitter" should "fit Logistic Function" in {
    val logistic: Logistic = Logistic(-1, 6, 3)
    println(s"Logistic(-1,2,3) = ${logistic}")
    val xData = 1 to 100
    println(s"{1 to 20} = ${xData}")
    val yData = for (x <- xData) yield logistic.value(x)
    println(util.Arrays.toString(yData.toArray))

    val observations = new util.ArrayList[WeightedObservedPoint](xData.length)
    for (x <- xData) {
      observations.add(new WeightedObservedPoint(0, x, logistic.value(x)))
    }
    val logisticFitter = LogisticFitter(Array[Double](0, 0, 0))
    val parameter: Array[Double] = logisticFitter.fit(observations)
    println(util.Arrays.toString(parameter))
    val logisticf = logisticFitter.fitToLogistic(observations)
    println(logisticf)
  }
}
