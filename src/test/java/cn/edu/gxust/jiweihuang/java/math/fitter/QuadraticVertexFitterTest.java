package cn.edu.gxust.jiweihuang.java.math.fitter;


import cn.edu.gxust.jiweihuang.java.math.function.univariate.QuadraticVertex;
import org.hipparchus.fitting.WeightedObservedPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QuadraticVertexFitterTest {
    public static void main(String... args) {
        QuadraticVertex quadraticVertex = new QuadraticVertex(2, 0.9, 0.1);
        double[] x = new double[]{-5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        List<WeightedObservedPoint> observedPoints = new ArrayList(x.length);
        for (double xi : x) {
            System.out.println(xi + ":" + quadraticVertex.value(xi));
            observedPoints.add(new WeightedObservedPoint(0, xi, quadraticVertex.value(xi)));
        }
        System.out.println(Arrays.toString(LogisticFitter.create().withStartPoint(new double[]{1, 1, 0}).fit(observedPoints)));
    }
}