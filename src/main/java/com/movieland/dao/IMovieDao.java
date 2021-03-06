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

    void removeMovie(int movie_id);

    void addMovie(Movie movie);

    void editMovie(int movie_id, Movie edited);

/*
      void generateReport();
    */
}
