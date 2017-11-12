package com.atmarkplant.collaborativefiltering.data;

import com.atmarkplant.collaborativefiltering.math.Distance;
import com.atmarkplant.collaborativefiltering.math.MatCalculation;
import lombok.Data;

@Data
public class MovieSims {

    double[][] moviesims;

    int memberSize;

    int movieSize;

    public MovieSims(int memberSize, int movieSize) {
        this.memberSize = memberSize;
        this.movieSize = movieSize;
        moviesims = MatCalculation.zeros(memberSize, memberSize);
    }

    public void calculateSims(Distance distance, double[][] reviews) {

        for (int i=0; i < memberSize; i++) {
            for (int j=0; j < memberSize; j++) {
                // i, j data set
                moviesims[i][j] = distance.distance(getDataSet(i, reviews), getDataSet(j, reviews));
            }
        }
    }

    private double[] getDataSet(int index, double[][] reviews) {
        double[] res = new double[movieSize];
        for (int i=0; i < movieSize; i++) {
            res[i] = reviews[index][i];
        }
        return res;
    }
}
