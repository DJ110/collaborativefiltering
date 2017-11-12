package com.atmarkplant.collaborativefiltering.math;

public class MatCalculation {

    public static double[][] zeros(int rows, int cols) {
        double[][] res = new double[rows][cols];
        // init 0
        for (int i=0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = 0.0;
            }
        }
        return res;
    }
}
