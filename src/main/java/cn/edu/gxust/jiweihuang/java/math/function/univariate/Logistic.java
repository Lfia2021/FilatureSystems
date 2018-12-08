package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import java.util.Objects;

public class Logistic implements ILogistic {
    private final double logisticM;
    private final double logisticK;
    private final double logisticX0;

    public Logistic(final double logisticM,
                    final double logisticK, final double logisticX0) {
        if (logisticM == 0) {
            throw new IllegalArgumentException(String.format(
                    "Expected the parameter {logisticM} is not equal 0,but got {logisticM = %f}", getLogisticM()));
        }
        this.logisticM = logisticM;
        this.logisticK = logisticK;
        this.logisticX0 = logisticX0;
    }

    public Logistic(final double logisticK, double logisticX0) {
        this(1, logisticK, logisticX0);
    }

    public Logistic(final double logisticK) {
        this(1, logisticK, 0);
    }

    public Logistic() {
        this(1, 1, 0);
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
        if (!(obj instanceof Logistic)) return false;
        Logistic logistic = (Logistic) obj;
        return Double.compare(logistic.getLogisticM(), getLogisticM()) == 0 &&
                Double.compare(logistic.getLogisticK(), getLogisticK()) == 0 &&
                Double.compare(logistic.getLogisticX0(), getLogisticX0()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogisticM(), getLogisticK(), getLogisticX0());
    }

    @Override
    public String toString() {
        return String.format("Logistic(%f,%f,%f)", getLogisticM(), getLogisticK(), getLogisticX0());
    }
}
