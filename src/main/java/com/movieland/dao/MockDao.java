package com.movieland.dao;

import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class MockDao {

    @Autowired
    private Movie movie;

    public MockDao() {
        System.out.println("MockDao created");
    }

    @Autowired
    public void setMovie(Movie movie) {
        this.movie = movie;
        System.out.println("Movie was set in mockDao");
    }

    /*@PostConstruct
    @Autowired
    private void init(Movie movie){
        this.movie = movie;
    }*/

    public Collection<Movie> getAll() {
        movie = new Movie();
        Collection<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        return movies;
    }
}
