package cn.edu.gxust.jiweihuang.scala.math.fitter

import java.util

import cn.edu.gxust.jiweihuang.scala.math.function.univariate.TLogistic
import org.hipparchus.fitting.AbstractCurveFitter.TheoreticalValuesFunction
import org.hipparchus.fitting.{AbstractCurveFitter, WeightedObservedPoint}
import org.hipparchus.linear.DiagonalMatrix
import org.hipparchus.optim.nonlinear.vector.leastsquares.{LeastSquaresBuilder, LeastSquaresProblem}

class LogisticFitter(val initialGuess: Array[Double] =
                     new Array[Double](3),
                     val maxIter: Int = Int.MaxValue)
  extends AbstractCurveFitter {

  val logisticFunction: TLogistic.Parametric = new TLogistic.Parametric()

  def withStartPoint(newStart: Array[Double]): LogisticFitter = {
    LogisticFitter(newStart.clone(), maxIter)
  }

  def withMaxIterations(newMaxIter: Int): LogisticFitter = {
    LogisticFitter(initialGuess, newMaxIter)
  }

  override def getProblem(points: util.Collection[WeightedObservedPoint]): LeastSquaresProblem = {

    // Prepare least-squares problem.
    import scala.collection.JavaConverters._
    val bufferp = points.asScala
    val targets = bufferp.map(f => f.getY).toArray
    val weights = bufferp.map(f => f.getWeight).toArray

    val model: TheoreticalValuesFunction = new TheoreticalValuesFunction(logisticFunction, points)

    // Return a new optimizer set up to fit a Gaussian curve to the
    // observed points.
    new LeastSquaresBuilder().maxEvaluations(Int.MaxValue).
      maxIterations(maxIter).
      start(initialGuess).
      target(targets).
      weight(new DiagonalMatrix(weights)).
      model(model.getModelFunction,
        model.getModelFunctionJacobian).build
  }

  def fitToLogistic(observations: util.Collection[WeightedObservedPoint]): TLogistic = {
    val p: Array[Double] = fit(observations)
    TLogistic(p(0), p(1), p(2))
  }
}

object LogisticFitter {
  def apply(initialGuess: Array[Double] = new Array[Double](3),
            maxIter: Int = Int.MaxValue): LogisticFitter =
    new LogisticFitter(initialGuess, maxIter)
}