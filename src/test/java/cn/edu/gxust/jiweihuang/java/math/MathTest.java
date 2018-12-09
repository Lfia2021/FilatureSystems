package cn.edu.gxust.jiweihuang.java.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathTest {

    @Test
    void getInstance() {
        assertEquals(Math.getInstance(), Math.getInstance());
    }

    @Test
    void staticDefaultNumbericalPrecision() {
        assertEquals(1.0e-15, Math.DefaultNumericalPrecision);
        System.out.println(String.format("Math.DefaultNumericalPrecision = %.1e", Math.DefaultNumericalPrecision));
    }
}