package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import java.util.Objects;

public class QuadraticVertexLogistic implements IQuadraticVertexLogistic {
    private final double quadraticVertexA;
    private final double quadraticVertexB;
    private final double quadraticVertexC;
    private final double logisticM;
    private final double logisticK;
    private final double logisticX0;
    private final double quadraticVertexLogisticD;

    public QuadraticVertexLogistic(final double quadraticVertexA,
                                   final double quadraticVertexB,
                                   final double quadraticVertexC,
                                   final double logisticM,
                                   final double logisticK,
                                   final double logisticX0,
                                   final double quadraticVertexLogisticD) {
        if (quadraticVertexA == 0) {
            throw new IllegalArgumentException(String.format(
                    "Expected the parameter {quadraticVertexA} not equal to 0,but got {quadraticVertexA = %f}", quadraticVertexA
            ));
        }
        if (logisticM == 0) {
            throw new IllegalArgumentException(String.format(
                    "Expected the parameter {logisticM} is not equal 0,but got {logisticM = %f}", getLogisticM()));
        }
        this.quadraticVertexA = quadraticVertexA;
        this.quadraticVertexB = quadraticVertexB;
        this.quadraticVertexC = quadraticVertexC;
        this.logisticM = logisticM;
        this.logisticK = logisticK;
        this.logisticX0 = logisticX0;
        this.quadraticVertexLogisticD = quadraticVertexLogisticD;
    }


    @Override
    public double getQuadraticVertexA() {
        return quadraticVertexA;
    }

    @Override
    public double getQuadraticVertexB() {
        return quadraticVertexB;
    }

    @Override
    public double getQuadraticVertexC() {
        return quadraticVertexC;
    }

    @Override
    public double getQuadraticVertexLogisticD() {
        return quadraticVertexLogisticD;
    }

    @Override
    public double getLogisticM() {
        return logisticM;
    }

    @Override
    public double getLogisticK() {
        return logisticK;
    }

    @Override
    public double getLogisticX0() {
        return logisticX0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuadraticVertexLogistic)) return false;
        QuadraticVertexLogistic that = (QuadraticVertexLogistic) obj;
        return Double.compare(that.getQuadraticVertexA(), getQuadraticVertexA()) == 0 &&
                Double.compare(that.getQuadraticVertexB(), getQuadraticVertexB()) == 0 &&
                Double.compare(that.getQuadraticVertexC(), getQuadraticVertexC()) == 0 &&
                Double.compare(that.getLogisticM(), getLogisticM()) == 0 &&
                Double.compare(that.getLogisticK(), getLogisticK()) == 0 &&
                Double.compare(that.getLogisticX0(), getLogisticX0()) == 0 &&
                Double.compare(that.getQuadraticVertexLogisticD(), getQuadraticVertexLogisticD()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC(), getLogisticM(), getLogisticK(), getLogisticX0(), getQuadraticVertexLogisticD());
    }

    @Override
    public String toString() {
        return String.format("QuadraticVertexLogistic(%f,%f,%f,%f,%f,%f,%f)", getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC(), getLogisticM(), getLogisticK(), getLogisticX0(), getQuadraticVertexLogisticD());
    }
}
