package cn.edu.gxust.jiweihuang.java.math.fitter;

import cn.edu.gxust.jiweihuang.java.math.function.univariate.IQuadraticVertex;
import org.hipparchus.fitting.AbstractCurveFitter;
import org.hipparchus.fitting.WeightedObservedPoint;
import org.hipparchus.linear.DiagonalMatrix;
import org.hipparchus.optim.nonlinear.vector.leastsquares.LeastSquaresBuilder;
import org.hipparchus.optim.nonlinear.vector.leastsquares.LeastSquaresProblem;

import java.util.Collection;

public class QuadraticVertexFitter extends AbstractCurveFitter {

    private static final IQuadraticVertex.Parametric FUNCTION = new IQuadraticVertex.Parametric() {
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
            double[] v = new double[]{Double.POSITIVE_INFINITY,
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

    private QuadraticVertexFitter(double[] initialGuess, int maxIter) {
        this.initialGuess = initialGuess == null ? null : initialGuess.clone();
        this.maxIter = maxIter;
    }

    public static QuadraticVertexFitter create() {
        return new QuadraticVertexFitter(null, Integer.MAX_VALUE);
    }

    public QuadraticVertexFitter withStartPoint(double[] newStart) {
        return new QuadraticVertexFitter(newStart.clone(),
                maxIter);
    }

    public QuadraticVertexFitter withMaxIterations(int newMaxIter) {
        return new QuadraticVertexFitter(initialGuess,
                newMaxIter);
    }

    @Override
    protected LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> observations) {
        // Prepare least-squares problem.
        final int len = observations.size();
        final double[] target = new double[len];
        final double[] weights = new double[len];

        int i = 0;
        for (WeightedObservedPoint obs : observations) {
            target[i] = obs.getY();
            weights[i] = obs.getWeight();
            ++i;
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
                target(target).
                weight(new DiagonalMatrix(weights)).
                model(model.getModelFunction(), model.getModelFunctionJacobian()).
                build();
    }
}
