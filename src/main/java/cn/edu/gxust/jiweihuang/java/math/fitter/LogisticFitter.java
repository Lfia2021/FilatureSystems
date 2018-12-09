package cn.edu.gxust.jiweihuang.java.math.fitter;

import cn.edu.gxust.jiweihuang.java.math.function.univariate.ILogistic;
import org.hipparchus.fitting.AbstractCurveFitter;
import org.hipparchus.fitting.WeightedObservedPoint;
import org.hipparchus.linear.DiagonalMatrix;
import org.hipparchus.optim.nonlinear.vector.leastsquares.LeastSquaresBuilder;
import org.hipparchus.optim.nonlinear.vector.leastsquares.LeastSquaresProblem;

import java.util.Collection;

public class LogisticFitter extends AbstractCurveFitter {

    private static final ILogistic.Parametric FUNCTION = new ILogistic.Parametric() {
        @Override
        public double value(double x, double... p) {
            double v = Double.POSITIVE_INFINITY;
            try {
                v = super.value(x, p);
            } catch (IllegalArgumentException e) { // NOPMD
                // Do nothing.
            }
            return v;
        }

        @Override
        public double[] gradient(double x, double... p) {
            double[] v = {Double.POSITIVE_INFINITY,
                    Double.POSITIVE_INFINITY,
                    Double.POSITIVE_INFINITY};
            try {
                v = super.gradient(x, p);
            } catch (IllegalArgumentException e) { // NOPMD
                // Do nothing.
            }
            return v;
        }
    };
    /**
     * Initial guess.
     */
    private final double[] initialGuess;
    /**
     * Maximum number of iterations of the optimization algorithm.
     */
    private final int maxIter;

    private LogisticFitter(double[] initialGuess, int maxIter) {
        this.initialGuess = initialGuess == null ? null : initialGuess.clone();
        this.maxIter = maxIter;
    }

    public static LogisticFitter create() {
        return new LogisticFitter(null, Integer.MAX_VALUE);
    }

    public LogisticFitter withStartPoint(double[] newStart) {
        return new LogisticFitter(newStart.clone(),
                maxIter);
    }

    public LogisticFitter withMaxIterations(int newMaxIter) {
        return new LogisticFitter(initialGuess,
                newMaxIter);
    }

    @Override
    protected LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> observations) {
        // Prepare least-squares problem.
        final int length = observations.size();
        final double[] targets = new double[length];
        final double[] weights = new double[length];

        int count = 0;
        for (WeightedObservedPoint obs : observations) {
            targets[count] = obs.getY();
            weights[count] = obs.getWeight();
            ++count;
        }

        final AbstractCurveFitter.TheoreticalValuesFunction model =
                new AbstractCurveFitter.TheoreticalValuesFunction(FUNCTION, observations);

        final double[] startPoint = initialGuess != null ?
                initialGuess :
                // Compute estimation.
                new double[]{1, 1, 0};

        // Return a new least squares problem set up to fit a Gaussian curve to the
        // observed points.
        return new LeastSquaresBuilder().
                maxEvaluations(Integer.MAX_VALUE).
                maxIterations(maxIter).
                start(startPoint).
                target(targets).
                weight(new DiagonalMatrix(weights)).
                model(model.getModelFunction(), model.getModelFunctionJacobian()).
                build();
    }


}
