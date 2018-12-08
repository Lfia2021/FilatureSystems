package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class QuadraticVertexLogisticTest {
    private final QuadraticVertexLogistic qvl = new QuadraticVertexLogistic(0.5E-5, 1200, 0, 1, 0.005, 300, 1.8);

    @BeforeEach
    void setUp() {
        System.out.println("Test the class QuadraticVertexLogistic");
        System.out.println(qvl);
        System.out.println(qvl.formula());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test the class QuadraticVertexLogistic Over");
    }

    @Test
    void quadraticVertexA() {
        assertEquals(0.5e-5, qvl.getQuadraticVertexA());
    }

}