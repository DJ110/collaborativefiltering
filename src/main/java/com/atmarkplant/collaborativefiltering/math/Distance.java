package com.atmarkplant.collaborativefiltering.math;

import java.util.List;

abstract public class Distance {

    protected void validation(List<Double> a, List<Double> b) {
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("2 list size does no match");
        }
    }

    abstract public double distance(List<Double> list1, List<Double> list2);


    protected void validation(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("2 list size does no match");
        }
    }

    abstract public double distance(double[] list1, double[] list2);
}
