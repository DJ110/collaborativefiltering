package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;

import java.util.Map;

@Data
public class MovieReviewCalc {

    private String[] names;

    private double[][] reviews;

    private String[] movies;

    private int membersize;

    private int moviesize;

    public MovieReviewCalc(MovieReview movieReview, MovieList movieList, int membersize, int moviesize) {
        this.membersize = membersize;
        this.moviesize = moviesize;
        read(movieReview, movieList);
    }

    private void read(MovieReview movieReview, MovieList movieList) {
        reviews = new double[membersize][moviesize];
        names = new String[membersize];
        movies = new String[moviesize];

        int index = 0;
        for (String target : movieReview.getReviews().keySet()) {
            names[index] = target;
            Map<String, Double> reviewset = movieReview.getReviews().get(target);
            int movieindex = 0;
            for (String movie : movieList.getMovielist()) {
                movies[movieindex] = movie;
                reviews[index][movieindex++] = reviewset.get(movie) == null ? 0.0 : reviewset.get(movie);
            }
            index++;
        }
    }
}
