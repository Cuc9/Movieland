package dao;

import dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class MockDao implements IMovieDao {

    @Autowired
    Movie movie;

    public Collection<Movie> getAll() {
        Collection<Movie> movies = new ArrayList<Movie>();
        movies.add(movie);
        return movies;
    }
}
