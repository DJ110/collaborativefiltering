package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;

@Data
public class MovieSimPersons {

    private String[] simpersons;

    private int memberSize;

    public MovieSimPersons(int memberSize) {
        this.memberSize = memberSize;
    }

    public void calculateSimpersons(double[][] sims, String[] names) {
        simpersons = new String[memberSize];
        for (int i=0; i < memberSize; i++) {
            simpersons[i] = simPerson(sims, names, i);
        }
    }

    private static String simPerson(double[][] sim, String names[], int index) {
        String res = "";
        int targetIndex = 0;
        double max = 0.0;
        for (int i=0; i < names.length; i++) {
            if (index != i) {
                if (max < sim[index][i]) {
                    max = sim[index][i];
                    targetIndex = i;
                }
            }
        }
        res = names[targetIndex];
        return res;
    }
}
