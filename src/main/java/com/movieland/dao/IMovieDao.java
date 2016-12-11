package com.movieland.dao;

import com.movieland.dbObjects.Movie;

import java.util.Collection;
import java.util.List;

/**
 * Created by arpi on 04.12.2016.
 */
public interface IMovieDao {
    Collection<Movie> getAll();

    Movie getById(int movie_id);

    void store (Movie movie);

/*    Review getReviewForMovie(int movie_id);

    void addReview(Review review);

    void addMovie(Movie movie);

    void editMovie(int movie_id, Movie edited);

    void removeMovie(int movie_id);

    void generateReport();

    void removeReview(int review_id);*/
}
