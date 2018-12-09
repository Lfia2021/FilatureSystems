package cn.edu.gxust.jiweihuang.java.math.function.univariate;

public interface IUnivariateIntegralFunction extends IUnivariateFunction {
    //double integralConstant = 0.0
    double integrate(double x);

    //definite integration
    default double integrate(double lowerX, double upperX) {
        return integrate(upperX) - integrate(lowerX);
    }
}
