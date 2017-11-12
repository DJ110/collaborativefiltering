package com.atmarkplant.collaborativefiltering.math;

import java.util.List;

public class CosineDistance extends Distance {

    public double distance(List<Double> list1, List<Double> list2) {
        validation(list1, list2);
        return VectorCalculation.innerProduct(list1, list2) / (VectorCalculation.absoluteValue(list1) * VectorCalculation.absoluteValue(list2));
    }

    public double distance(double[] list1, double[] list2) {
        validation(list1, list2);
        return VectorCalculation.innerProduct(list1, list2) / (VectorCalculation.absoluteValue(list1) * VectorCalculation.absoluteValue(list2));
    }

}