package cn.edu.gxust.jiweihuang.java.math.fitter;

import cn.edu.gxust.jiweihuang.java.math.function.univariate.Logistic;
import org.hipparchus.fitting.WeightedObservedPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LogisticFitterTest {
    public static void main(String... args) {
        Logistic logistic = new Logistic(0.8, 0.9, 0.1);
        double[] x = new double[]{-0.5,0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6};
        List<WeightedObservedPoint> observedPoints = new ArrayList(x.length);
        for (double xi : x) {
            System.out.println(xi + ":" + logistic.value(xi));
            observedPoints.add(new WeightedObservedPoint(0, xi, logistic.value(xi)));
        }
        System.out.println(Arrays.toString(LogisticFitter.create().withStartPoint(new double[]{1, 1, 1}).fit(observedPoints)));
    }
}