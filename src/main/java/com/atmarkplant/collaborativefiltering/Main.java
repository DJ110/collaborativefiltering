package com.atmarkplant.collaborativefiltering;

import com.atmarkplant.collaborativefiltering.data.*;
import com.atmarkplant.collaborativefiltering.math.CosineDistance;
import com.atmarkplant.collaborativefiltering.results.MoviePrefHTML;

public class Main {

    public static void main(String[] args) {

        // 1. Read data
        // Movie list
        MovieList movieList = new MovieList("src/main/resources/movielist.txt");
        movieList.read();
        // Movie reviews
        MovieReview movieReview = new MovieReview("src/main/resources/moviepref.json");
        movieReview.read();
        MovieReviewCalc movieReviewCalc = new MovieReviewCalc(movieReview, movieList, movieReview.getReviewMemberSize(), movieList.getMovieListSize());

        // 2. Calculate similarity
        MovieSims movieSims = new MovieSims(movieReviewCalc.getMembersize(), movieList.getMovieListSize());
        movieSims.calculateSims(new CosineDistance(), movieReviewCalc.getReviews());

        // 3. Calculate recommendation scores
        MovieRecomsScores movieRecomsScores = new MovieRecomsScores(movieReviewCalc.getMembersize(), movieList.getMovieListSize());
        movieRecomsScores.calculateScores(movieSims.getMoviesims(), movieReviewCalc.getReviews());

        // 4. Recommendation result algorithm
        MovieRecoms movieRecoms = new MovieTopOneRecoms(movieReviewCalc.getMembersize(), movieList.getMovieListSize());
        movieRecoms.calculateRecoms(movieList.getMovieListArray(), movieRecomsScores.getScores());

        // 5. Retrieve the highest sim people
        MovieSimPersons movieSimPersons = new MovieSimPersons(movieReviewCalc.getMembersize());
        movieSimPersons.calculateSimpersons(movieSims.getMoviesims(), movieReviewCalc.getNames());

        // 6. Results
        MoviePrefHTML moviePrefHTML = new MoviePrefHTML("src/main/resources/index.html", "Results");
        moviePrefHTML.setMovies(movieList.getMovieListArray());
        moviePrefHTML.setNames(movieReviewCalc.getNames());
        moviePrefHTML.setReviews(movieReviewCalc.getReviews());
        moviePrefHTML.setRecoms(movieRecoms.getRecoms());
        moviePrefHTML.setScores(movieRecomsScores.getScores());
        moviePrefHTML.setSim(movieSims.getMoviesims());
        moviePrefHTML.setSimpersons(movieSimPersons.getSimpersons());
        moviePrefHTML.createHTML();
    }
}
