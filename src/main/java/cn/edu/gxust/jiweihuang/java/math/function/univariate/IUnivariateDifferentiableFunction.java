package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.differentiation.DSFactory;
import org.hipparchus.analysis.differentiation.UnivariateDifferentiableFunction;

public interface IUnivariateDifferentiableFunction extends IUnivariateFunction,
        UnivariateDifferentiableFunction {
    default double differential(double x, int order) {
        return value(new DSFactory(1, order).variable(0,
                x)).getPartialDerivative(1);
    }

    default double differential(double x) {
        return differential(x, 1);
    }
}
