package com.atmarkplant.collaborativefiltering.data;

import com.atmarkplant.collaborativefiltering.math.Distance;
import com.atmarkplant.collaborativefiltering.math.MatCalculation;
import lombok.Data;

@Data
public class MovieRecomsScores {

    private double[][] scores;

    private int nameSize;

    private int movieSize;


    public MovieRecomsScores(int nameSize, int movieSize) {
        this.nameSize = nameSize;
        this.movieSize = movieSize;
        scores = MatCalculation.zeros(nameSize, movieSize);
    }

    public void calculateScores(double[][] sims, double[][] reviews) {
        for (int i=0; i < nameSize; i++) {
            for (int j = 0; j < movieSize; j++) {
                for (int k=0; k < nameSize; k++) {
                    scores[i][j] += (sims[i][k] * reviews[k][j]);
                }
                for (int k=0; k < nameSize; k++) {
                    if (i == k && reviews[k][j] > 0) {
                        scores[i][j] = 0.0;
                    }
                }
            }
        }
    }
}
