package cn.edu.gxust.jiweihuang.java.math.function.univariate;

public interface IQuadratic extends IUnivariateFunction,
        IUnivariateDerivativeFunction,
        IUnivariateDifferentiableFunction,
        IUnivariateIntegrableFunction,
        IUnivariateIntegralFunction,
        IUnivariateInverseFunction {
    boolean isInvert();

    double[] xIntersection();

    double yIntersection();

    double[] vertex();

    int xIntersectionNum();

}
