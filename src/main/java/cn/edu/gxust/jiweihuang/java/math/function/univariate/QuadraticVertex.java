package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import java.util.Objects;

public class QuadraticVertex implements IQuadraticVertex {
    private final double quadraticVertexA;
    private final double quadraticVertexB;
    private final double quadraticVertexC;

    public QuadraticVertex(final double quadraticVertexA, final double quadraticVertexB,
                           final double quadraticVertexC) {
        if (quadraticVertexA == 0) {
            throw new IllegalArgumentException(String.format(
                    "Expected the parameter {quadraticVertexA} not equal to 0,but got {quadraticVertexA = %f}", quadraticVertexA
            ));
        }
        this.quadraticVertexA = quadraticVertexA;
        this.quadraticVertexB = quadraticVertexB;
        this.quadraticVertexC = quadraticVertexC;
    }

    public QuadraticVertex(final double quadraticVertexA, final double quadraticVertexB) {
        this(quadraticVertexA, quadraticVertexB, .0);
    }

    public QuadraticVertex(final double quadraticVertexA) {
        this(quadraticVertexA, 0.0, 0.0);
    }

    public QuadraticVertex() {
        this(1.0, 0.0, 0.0);
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuadraticVertex)) return false;
        QuadraticVertex that = (QuadraticVertex) obj;
        return Double.compare(that.getQuadraticVertexA(), getQuadraticVertexA()) == 0 &&
                Double.compare(that.getQuadraticVertexB(), getQuadraticVertexB()) == 0 &&
                Double.compare(that.getQuadraticVertexC(), getQuadraticVertexC()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC());
    }

    @Override
    public String toString() {
        return String.format("QuadraticVertex(%f,%f,%f)", getQuadraticVertexA(), getQuadraticVertexB(), getQuadraticVertexC());
    }
}
