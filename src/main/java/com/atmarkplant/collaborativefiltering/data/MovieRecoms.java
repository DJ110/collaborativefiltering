package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;

@Data
abstract public class MovieRecoms {

    protected String[] recoms;

    protected int memberSize;

    protected int movieSize;

    public MovieRecoms(int memberSize, int movieSize) {
        this.memberSize = memberSize;
        this.movieSize = movieSize;
        this.recoms = new String[memberSize];
    }

    abstract public void calculateRecoms(String[] movieList, double[][] scores);
}
