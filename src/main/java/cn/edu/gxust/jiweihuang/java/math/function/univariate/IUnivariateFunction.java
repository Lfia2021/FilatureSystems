package cn.edu.gxust.jiweihuang.java.math.function.univariate;

import org.hipparchus.analysis.UnivariateFunction;

import java.io.Serializable;

public interface IUnivariateFunction extends
        UnivariateFunction, Serializable {
    String formula();
}
