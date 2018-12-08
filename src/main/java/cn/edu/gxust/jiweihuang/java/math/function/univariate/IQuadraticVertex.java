package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.ParametricUnivariateFunction;
import org.hipparchus.analysis.differentiation.DerivativeStructure;

public interface IQuadraticVertex extends IQuadratic {
    double getQuadraticVertexA();

    double getQuadraticVertexB();

    double getQuadraticVertexC();

    @Override
    default double[] vertex() {
        return new double[]{getQuadraticVertexB(), getQuadraticVertexC()};
    }

    @Override
    default boolean isInvert() {
        return getQuadraticVertexA() < 0;
    }

    @Override
    default double[] xIntersection() {
        double tem = -getQuadraticVertexC() / getQuadraticVertexA();
        if (tem > 0) {
            return new double[]{getQuadraticVertexB() + Math.sqrt(tem), getQuadraticVertexB() - Math.sqrt(tem)};
        } else if (tem == 0) {
            return new double[]{getQuadraticVertexB()};
        } else {
            return new double[]{};
        }
    }

    @Override
    default double yIntersection() {
        return getQuadraticVertexA() * Math.pow(getQuadraticVertexB(), 2) + getQuadraticVertexC();
    }

    @Override
    default int xIntersectionNum() {
        return xIntersection().length;
    }

    @Override
    default String formula() {
        return String.format("%f * pow(x-%f,2) + %f", getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC());
    }

    @Override
    default double value(double x) {
        return getQuadraticVertexA() * Math.pow(x - getQuadraticVertexB(), 2) + getQuadraticVertexC();
    }

    @Override
    default DerivativeStructure value(DerivativeStructure t) {
        return t.subtract(getQuadraticVertexB()).pow(2).multiply(getQuadraticVertexA()).add(getQuadraticVertexC());
    }

    @Override
    default double[] inverse(double x) {
        double tem = Math.sqrt(getQuadraticVertexA() * (x - getQuadraticVertexC()));
        return new double[]{(getQuadraticVertexA() * getQuadraticVertexB() - tem) / getQuadraticVertexA(),
                (getQuadraticVertexA() * getQuadraticVertexB() + tem) / getQuadraticVertexA()};
    }

    @Override
    default double integrate(double x) {
        return getQuadraticVertexA() * Math.pow(getQuadraticVertexB(), 2) * x +
                getQuadraticVertexC() * x - getQuadraticVertexA() * getQuadraticVertexB() * Math.pow(x, 2) +
                getQuadraticVertexA() * Math.pow(x, 3) / 3.0;
    }

    @Override
    default double derivative(double x) {
        return 2 * getQuadraticVertexA() * (x - getQuadraticVertexB());
    }

    class Parametric implements ParametricUnivariateFunction {

        @Override
        public double value(double x, double... parameters) {
            checkParameter(parameters);
            double a = parameters[0];
            double b = parameters[1];
            double c = parameters[2];
            return a * Math.pow(x - b, 2) + c;
        }

        @Override
        public double[] gradient(double x, double... parameters) {
            checkParameter(parameters);
            double a = parameters[0];
            double b = parameters[1];
            double c = parameters[2];
            double[] make_arr = new double[3];
            make_arr[0] = Math.pow(x - b, 2);
            make_arr[1] = -2 * a * (x - b);
            make_arr[2] = 1;
            return make_arr;
        }

        private void checkParameter(double[] parameters) {
            if (parameters == null)
                throw new IllegalArgumentException(String.format("Expected the parameter {parameter} is not null,but got {parameters = null}"));
            else if (parameters.length != 3)
                throw new IllegalArgumentException(String.format("Expected the parameter {parameters.length} equals to 3,but got {parameters.length = %d}", parameters.length));
            else if (parameters[0] == 0)
                throw new IllegalArgumentException(String.format("Expected the parameter {parameters[0]} not equal to 0,but got {parameters[0] = %f}", parameters[0]));
        }
    }

    static double quadraticVertex(double x, double... parameter) {
        //a = parameter[0]
        //b = parameter[1]
        //c = parameter[2]
        return parameter[0] * Math.pow(x - parameter[1], 2) + parameter[2];
    }

    static double quadraticVertexDerivative(double x, double... parameter) {
        //a = parameter[0]
        //b = parameter[1]
        //c = parameter[2]
        return 2 * parameter[0] * (x - parameter[1]);
    }

    static double quadraticVertexIntegrate(double x, double... parameter) {
        //a = parameter[0]
        //b = parameter[1]
        //c = parameter[2]
        return parameter[0] * Math.pow(parameter[1], 2) * x +
                parameter[2] * x - parameter[0] * parameter[1] *
                Math.pow(x, 2) + parameter[0] * Math.pow(x, 3) / 3.0;
    }

    static double quadraticVertexDerivativeA(double x, double... parameter) {
        return Math.pow(x - parameter[1], 2);
    }

    static double quadraticVertexDerivativeB(double x, double... parameter) {
        return -2 * parameter[0] * (x - parameter[1]);
    }

    static double quadraticVertexDerivativeC(double x, double... parameter) {
        return 1;
    }

}
