package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.ParametricUnivariateFunction;
import org.hipparchus.analysis.differentiation.DerivativeStructure;

public interface IQuadraticVertexLogistic extends
        IUnivariateFunction, IUnivariateDerivativeFunction,
        IUnivariateDifferentiableFunction,
        IUnivariateIntegrableFunction {

    double getQuadraticVertexA();

    double getQuadraticVertexB();

    double getQuadraticVertexC();

    double getQuadraticVertexLogisticD();

    double getLogisticM();

    double getLogisticK();

    double getLogisticX0();

    default IQuadraticVertex getQuadraticVertex() {
        return new QuadraticVertex(getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC());
    }

    default ILogistic getLogistic() {
        return new Logistic(getLogisticM(), getLogisticK(), getLogisticX0());
    }

    @Override
    default double value(double x) {
        return getQuadraticVertex().value(x) * getLogistic().value(x) + getQuadraticVertexLogisticD();
    }

    @Override
    default DerivativeStructure value(DerivativeStructure t) {
        return getQuadraticVertex().value(t).multiply(getLogistic().value(t)).add(getQuadraticVertexLogisticD());
    }

    @Override
    default double derivative(double x) {
        return getQuadraticVertex().derivative(x) * getLogistic().value(x) +
                getLogistic().derivative(x) * getQuadraticVertex().value(x);
    }

    @Override
    default String formula() {
        return String.format(
                "%f*(%f*pow(x-%f,2)+%f)/(1+exp(-%f*(x-%f)))+%f", getLogisticM(),
                getQuadraticVertexA(), getQuadraticVertexB(),
                getQuadraticVertexC(), getLogisticK(),
                getLogisticX0(), getQuadraticVertexLogisticD());
    }

    class Parametric implements ParametricUnivariateFunction {

        @Override
        public double value(double x, double... parameters) {
            checkParameter(parameters);
            return quadraticVertexLogistic(x, parameters);
        }

        @Override
        public double[] gradient(double x, double... parameters) {
            checkParameter(parameters);
            double[] make_array = new double[7];
            make_array[0] = quadraticVertexLogisticDerivativeA(x, parameters);
            make_array[1] = quadraticVertexLogisticDerivativeB(x, parameters);
            make_array[2] = quadraticVertexLogisticDerivativeC(x, parameters);
            make_array[3] = quadraticVertexLogisticDerivativeM(x, parameters);
            make_array[4] = quadraticVertexLogisticDerivativeK(x, parameters);
            make_array[5] = quadraticVertexLogisticDerivativeX0(x, parameters);
            make_array[6] = quadraticVertexLogisticDerivativeD(x, parameters);
            return make_array;
        }

    }

    static void checkParameter(double[] parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        if (parameters == null) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameter} is not null,but got {parameters = null}"
        ));
        if (parameters.length != 7) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameters.length} equals to 3,but got {parameters.length = %d}", parameters.length
        ));
        if (parameters[0] == 0) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameters[0]} not equal to 0,but got {parameters[0] = %f}", parameters[0]
        ));
        if (parameters[3] == 0) throw new IllegalArgumentException(String.format(
                "Expected the parameter {parameters[3]} not equal to 0,but got {parameters[3] = %f}", parameters[3]
        ));
    }

    static double quadraticVertexLogistic(double x, double... parameters) {
        return IQuadraticVertex.quadraticVertex(x, parameters[0], parameters[1], parameters[2]) * ILogistic.logistic(x, parameters[3], parameters[4], parameters[5]);
    }

    static double quadraticVertexLogisticDerivative(double x, double... parameters) {
        return IQuadraticVertex.quadraticVertexDerivative(x, parameters[0], parameters[1], parameters[2]) * ILogistic.logistic(x, parameters[3], parameters[4], parameters[5]) +
                ILogistic.logisticDerivative(x, parameters[3], parameters[4], parameters[5]) * IQuadraticVertex.quadraticVertex(x, parameters[0], parameters[1], parameters[2]);
    }

    static double quadraticVertexLogisticDerivativeA(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return parameters[3] * Math.pow(x - parameters[1], 2) / ILogistic.logisticExpPlusOne(x, parameters[3], parameters[4], parameters[5]);
    }

    static double quadraticVertexLogisticDerivativeB(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return -2 * parameters[0] * parameters[3] * (x - parameters[1]) / ILogistic.logisticExpPlusOne(x, parameters[3], parameters[4], parameters[5]);
    }

    static double quadraticVertexLogisticDerivativeC(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return ILogistic.logistic(x, parameters[3], parameters[4], parameters[5]);
    }

    static double quadraticVertexLogisticDerivativeM(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return IQuadraticVertex.quadraticVertex(x, parameters[0], parameters[2], parameters[2]) / ILogistic.logisticExpPlusOne(x, parameters[3], parameters[4], parameters[5]);
    }

    static double quadraticVertexLogisticDerivativeK(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return ILogistic.logisticExp(x, parameters[3], parameters[4], parameters[5]) * parameters[3] *
                IQuadraticVertex.quadraticVertex(x, parameters[0], parameters[1], parameters[2]) * (x - parameters[5]) / Math.pow(ILogistic.logisticExpPlusOne(x, parameters[3], parameters[4], parameters[5]), 2);
    }

    static double quadraticVertexLogisticDerivativeX0(double x, double... parameters) {
        // a = parameters[0]
        // b = parameters[1]
        // c = parameters[2]
        // m = parameters[3]
        // k = parameters[4]
        // x0 = parameters[5]
        // d = parameters[6]
        return ILogistic.logisticExp(x, parameters[3], parameters[4], parameters[5]) * parameters[3] *
                IQuadraticVertex.quadraticVertex(x, parameters[0], parameters[1], parameters[2]) * parameters[4] / Math.pow(ILogistic.logisticExpPlusOne(x, parameters[3], parameters[4], parameters[5]), 2);
    }

    static double quadraticVertexLogisticDerivativeD(double x, double... parameters) {
        return 1;
    }
}
