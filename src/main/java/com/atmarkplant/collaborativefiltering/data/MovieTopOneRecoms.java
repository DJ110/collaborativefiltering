package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieTopOneRecoms extends MovieRecoms {

    public MovieTopOneRecoms(int memberSize, int movieSize) {
        super(memberSize, movieSize);
    }

    @Override
    public void calculateRecoms(String[] movieList, double[][] scores) {
        // pick up the best
        for (int i=0; i < memberSize; i++) {
            int maxIndex = 0;
            double maxSocres = 0.0;
            // Check max scores
            for (int j = 0; j < movieSize; j++) {
                if (maxSocres < scores[i][j]) {
                    maxSocres = scores[i][j];
                    maxIndex = j;
                }
            }
            recoms[i] = movieList[maxIndex];
        }
    }
}
