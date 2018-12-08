package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.integration.*;

public interface IUnivariateIntegrableFunction extends IUnivariateFunction {
    int DefaultIntegrationPointsNumber = 32;

    default double integrateRomberg(double lowerX, double upperX) {
        return new RombergIntegrator().integrate(Integer.MAX_VALUE, this, lowerX, upperX);
    }

    default double integrateRomberg(double lowerX, double upperX, int maxIter) {
        return new RombergIntegrator().integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateRomberg(double lowerX, double upperX,
                                    int maxIter, double relativeAccuracy,
                                    double absoluteAccuracy,
                                    int minimalIterationCount,
                                    int maximalIterationCount) {
        return new RombergIntegrator(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateSimpson(double lowerX, double upperX) {
        return new SimpsonIntegrator().integrate(Integer.MAX_VALUE, this, lowerX, upperX);
    }

    default double integrateSimpson(double lowerX, double upperX, int maxIter) {
        return new SimpsonIntegrator().integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateSimpson(double lowerX, double upperX,
                                    int maxIter, double relativeAccuracy,
                                    double absoluteAccuracy,
                                    int minimalIterationCount,
                                    int maximalIterationCount) {
        return new SimpsonIntegrator(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateMidPoint(double lowerX, double upperX) {
        return new MidPointIntegrator().integrate(Integer.MAX_VALUE, this, lowerX, upperX);
    }

    default double integrateMidPoint(double lowerX, double upperX, int maxIter) {
        return new MidPointIntegrator().integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateMidPoint(double lowerX, double upperX,
                                     int maxIter, double relativeAccuracy,
                                     double absoluteAccuracy,
                                     int minimalIterationCount,
                                     int maximalIterationCount) {
        return new MidPointIntegrator(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateTrapezoid(double lowerX, double upperX) {
        return new TrapezoidIntegrator().integrate(Integer.MAX_VALUE, this, lowerX, upperX);
    }

    default double integrateTrapezoid(double lowerX, double upperX, int maxIter) {
        return new TrapezoidIntegrator().integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateTrapezoid(double lowerX, double upperX, int maxIter, double relativeAccuracy,
                                      double absoluteAccuracy,
                                      int minimalIterationCount,
                                      int maximalIterationCount) {
        return new TrapezoidIntegrator(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX, double upperX) {
        return new IterativeLegendreGaussIntegrator(DefaultIntegrationPointsNumber,
                BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT).integrate(Integer.MAX_VALUE, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX, double upperX, int maxIter) {
        return new IterativeLegendreGaussIntegrator(DefaultIntegrationPointsNumber,
                BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX, double upperX, int maxIter, int integrationPointsNumber) {
        return new IterativeLegendreGaussIntegrator(integrationPointsNumber,
                BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX,
                                                   double upperX,
                                                   int maxIter,
                                                   int integrationPointsNumber,
                                                   double relativeAccuracy,
                                                   double absoluteAccuracy) {
        return new IterativeLegendreGaussIntegrator(integrationPointsNumber,
                relativeAccuracy,
                absoluteAccuracy,
                BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX,
                                                   double upperX,
                                                   int maxIter,
                                                   int integrationPointsNumber,
                                                   int minimalIterationCount,
                                                   int maximalIterationCount) {
        return new IterativeLegendreGaussIntegrator(integrationPointsNumber,
                BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                minimalIterationCount,
                maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }

    default double integrateIterativeLegendreGauss(double lowerX,
                                                   double upperX,
                                                   int maxIter,
                                                   int integrationPointsNumber,
                                                   double relativeAccuracy,
                                                   double absoluteAccuracy,
                                                   int minimalIterationCount,
                                                   int maximalIterationCount) {
        return new IterativeLegendreGaussIntegrator(integrationPointsNumber,
                relativeAccuracy,
                absoluteAccuracy,
                minimalIterationCount,
                maximalIterationCount).integrate(maxIter, this, lowerX, upperX);
    }
}
