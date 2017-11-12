package com.atmarkplant.collaborativefiltering.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VectorCalculation {

    public static double innerProduct(List<Double> list1, List<Double> list2) {
        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("Size does not match");
        }
        double total = 0.0;
        for (int i=0; i < list1.size(); i++) {
            total += (list1.get(i) * list2.get(i));
        }
        return total;
    }

    public static double innerProduct(double[] list1, double[] list2) {
        if (list1.length != list2.length) {
            throw new IllegalArgumentException("Size does not match");
        }
        double total = 0.0;
        for (int i=0; i < list1.length; i++) {
            total += (list1[i] * list2[i]);
        }
        return total;
    }


    public static double absoluteValue(List<Double> target) {
        double total = 0.0;
        for (Double data : target) {
            total += (data * data);
        }
        return Math.sqrt(total);
    }


    public static double absoluteValue(double[] target) {
        double total = 0.0;
        for (Double data : target) {
            total += (data * data);
        }
        return Math.sqrt(total);
    }

    public static double nTh(List<Double> target, int index) {
        if (index > target.size()) {
            throw new IllegalArgumentException("Index is over size");
        }
        Collections.sort(target);
        return target.get(index-1);
    }

    public static double nTh(double[] target, int index) {
        if (index > target.length) {
            throw new IllegalArgumentException("Index is over size");
        }
        List<Double> list = new ArrayList<Double>();
        for (int i=0;i < target.length; i++) {
            list.add(target[i]);
        }
        Collections.sort(list);
        return list.get(index-1);
    }

}
