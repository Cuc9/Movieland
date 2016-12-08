package com.movieland.dao;

import com.movieland.dbObjects.Genre;
import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class H2Dao implements IMovieDao {

    @Autowired
    private JdbcTemplate db;

  /*  @PostConstruct
    private void init(){
        *//**extract DB name later*//*
        db.execute("USE movieland");
    }*/

    public List<Movie> getAll() {
        final List<Movie> allMovies = db.query("SELECT * FROM movie",
                new org.springframework.jdbc.core.RowMapper<Movie>() {
                    public Movie mapRow(ResultSet rs, int movieNumber) throws SQLException {
                        /**Reading fields*/
                        Integer id = rs.getInt("id");
                        String title = rs.getString("title");
                        Integer year = rs.getInt("year");
                        String country = rs.getString("country");
                        Float price = rs.getFloat("price");
                        Float raiting = rs.getFloat("raiting");
                        String description = rs.getString("description");

                        /**Creating Genres list. It collects from multiply tables in DB*/
                        final List<Genre> genres = new ArrayList<Genre>();
                        List<Integer> ids_g = db.queryForList("SELECT id_g FROM GENRE_RELATIONS WHERE id_m= ? ", new Object[]{id},Integer.class);
                        for (Integer id_g : ids_g) {
                            genres.add(db.queryForObject("SELECT * FROM genre WHERE id = ?", new Object[]{id_g},
                                    new org.springframework.jdbc.core.RowMapper<Genre>() {
                                        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
                                            Integer id = resultSet.getInt("id");
                                            String name = resultSet.getString("name");
                                            return new Genre(id, name);
                                        }
                                    }));
                        }

                        /** Preparin Movie object. Setting fields.*/
                        Movie movie = new Movie();
                        movie.setId(id);
                        movie.setTitle(title);
                        movie.setYear(year);
                        movie.setCountry(country);
                        movie.setGenres(genres);
                        movie.setPrice(price);
                        movie.setRaiting(raiting);
                        movie.setDescription(description);
                        return movie;
                    }
                });
        return allMovies;
    }
}
