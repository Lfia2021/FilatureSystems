package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.ParametricUnivariateFunction;
import org.hipparchus.analysis.differentiation.DerivativeStructure;

public interface ILogistic extends IUnivariateFunction,
        IUnivariateIntegralFunction, IUnivariateIntegrableFunction,
        IUnivariateDifferentiableFunction, IUnivariateDerivativeFunction {

    double getLogisticM();

    double getLogisticK();

    double getLogisticX0();

    @Override
    default String formula() {
        return String.format("%f/(1+exp(-%f*(x-%f)))", getLogisticM(), getLogisticK(), getLogisticX0());
    }

    default double logisticExp(double x) {
        return Math.exp(-getLogisticK() * (x - getLogisticX0()));
    }

    default double logisticExpAddOne(double x) {
        return 1 + logisticExp(x);
    }

    @Override
    default double value(double x) {
        return getLogisticM() / logisticExpAddOne(x);
    }

    @Override
    default DerivativeStructure value(DerivativeStructure t) {
        return t.subtract(getLogisticX0()).multiply(-getLogisticK()).exp().add(1).pow(-1).multiply(getLogisticM());
    }

    @Override
    default double derivative(double x) {
        return getLogisticM() * getLogisticK() * logisticExp(x) / Math.pow(logisticExpAddOne(x), 2);
    }

    @Override
    default double integrate(double x) {
        return getLogisticM() * (x + Math.log(logisticExpAddOne(x) / getLogisticK()));
    }

    class Parametric implements ParametricUnivariateFunction {

        @Override
        public double value(double x, double... parameters) {
            checkParameter(parameters);
            return logistic(x, parameters);
        }

        @Override
        public double[] gradient(double x, double... parameters) {
            checkParameter(parameters);
            double[] make_array = new double[3];
            make_array[0] = logisticDerivativeM(x, parameters);
            make_array[1] = logisticDerivativeK(x, parameters);
            make_array[2] = logisticDerivativeX0(x, parameters);
            return make_array;
        }
    }

    static void checkParameter(double[] parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        if (parameters == null) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameter} is not null,but got {parameters = null}"
        ));
        if (parameters.length != 3) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameters.length} equals to 3,but got {parameters.length = %d}", parameters.length
        ));
        if (parameters[0] == 0) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameters[0]} not equal to 0,but got {parameters[0] = %f}", parameters[0]
        ));
    }


    static double logisticExp(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return Math.exp(-parameters[1] * (x - parameters[2]));
    }

    static double logisticExpPlusOne(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return 1 + logisticExp(x, parameters);
    }

    static double logistic(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return parameters[0] / logisticExpPlusOne(x, parameters);
    }

    static double logisticDerivative(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return parameters[0] * parameters[1] * logisticExp(x, parameters) / Math.pow(logisticExpPlusOne(x, parameters), 2);
    }

    static double logisticIntegrate(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return parameters[0] * (x + Math.log(logisticExpPlusOne(x, parameters)) / parameters[1]);
    }

    static double logisticDerivativeM(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return 1 / logisticExpPlusOne(x, parameters);
    }

    static double logisticDerivativeK(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return logisticExp(x, parameters) * parameters[0] * (x - parameters[2]) / Math.pow(logisticExpPlusOne(x, parameters), 2);
    }

    static double logisticDerivativeX0(double x, double... parameters) {
        // m = parameter[0]
        // k = parameter[1]
        // x0 = parameter[2]
        return -logisticExp(x, parameters) * parameters[1] * parameters[0] / Math.pow(logisticExpPlusOne(x, parameters), 2);
    }
}
