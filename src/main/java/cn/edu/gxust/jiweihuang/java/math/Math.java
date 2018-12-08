package cn.edu.gxust.jiweihuang.java.math;

public class Math {
    private static Math instance = new Math();

    public static Math getInstance() {
        return instance;
    }

    private Math() {
    }

    public static double DefaultNumericalPrecision = 1.0e-15;
}
