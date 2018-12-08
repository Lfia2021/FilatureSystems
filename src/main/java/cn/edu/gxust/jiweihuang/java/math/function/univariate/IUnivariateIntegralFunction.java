package cn.edu.gxust.jiweihuang.java.math.function.univariate;

public interface IUnivariateIntegralFunction extends IUnivariateFunction {
    double integrate(double x);

    default double integrate(double lowerX, double upperX) {
        return integrate(upperX) - integrate(lowerX);
    }
}
