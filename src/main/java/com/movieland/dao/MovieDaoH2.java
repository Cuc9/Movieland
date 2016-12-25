package com.movieland.dao;

import com.movieland.dbObjects.Genre;
import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class MovieDaoH2 implements IMovieDao {

    @Autowired
    private JdbcTemplate db;
    @Autowired
    private GenreDaoH2 gDao;
/*    @Autowired
    private GenreDao gDao;*/

  /*  @PostConstruct
    private void init(){
        *//**extract DB name later*//*
        db.execute("USE movieland");
    }*/

    private Movie generateMovie(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String title = rs.getString("title");
        Integer year = rs.getInt("year");
        String country = rs.getString("country");
        Float price = rs.getFloat("price");
        Float raiting = rs.getFloat("raiting");
        String description = rs.getString("description");

        /**Creating Genres list.*/
        final List<Genre> genres = new ArrayList<Genre>();
        List<Integer> ids_g = db.queryForList("SELECT id_g FROM GENRE_RELATIONS WHERE id_m= ? ", new Object[]{id}, Integer.class);

        for (Integer id_g : ids_g) {
            genres.add(gDao.getGenre(id_g));
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

    public List<Movie> getAll() {
        final List<Movie> allMovies = db.query("SELECT * FROM movie",
                new org.springframework.jdbc.core.RowMapper<Movie>() {
                    public Movie mapRow(ResultSet rs, int movieNumber) throws SQLException {
                       return generateMovie(rs);
                    }
                });
        return allMovies;
    }

    public Movie getById(int movie_id) {
        db.execute("USE movieland");
        List<Movie> movie = db.query("SELECT * FROM movie WHERE id = ?",
                new RowMapper<Movie>() {
                    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                        return generateMovie(resultSet);
                    }
                }, (Integer) movie_id);
        return movie.get(0);
    }

    public void store(Movie movie) {
        String sql = "UPDATE movie " +
                "SET title = ?," +
                "year = ?," +
                "country = ?," +
                "description = ?," +
                "raiting = ?," +
                "price = ?" +
                "WHERE id = ?;";

        db.update(sql, movie.getTitle(), movie.getYear(), movie.getCountry(), movie.getDescription(),
                movie.getRaiting(), movie.getPrice(),movie.getId());
        System.out.println("Movie " + movie.getTitle() + " STORED in DB.");
    }

    public void addMovie(Movie movie) {
        String sqlm = "INSERT INTO movie (id, title, year, country, raiting, price, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        Integer id_m = movie.getId();
        db.update(sqlm, id_m, movie.getTitle(), movie.getYear(), movie.getCountry(), movie.getRaiting(),
                movie.getPrice(), movie.getDescription());
        String sqlg = "INSERT INTO genre_relations (id, id_m, id_g) " +
                "VALUES (?, ?, ?);";
        Integer id = db.queryForObject("SELECT MAX(id) FROM genre_relations;",Integer.class);
        List<Genre> genres = movie.getGenres();
        for (Genre g : genres) {
            db.update(sqlg, ++id, id_m, g.getId());
        }
    }

    public void removeMovie(int movie_id) {
        db.update("DELETE FROM movie WHERE id = ?", movie_id);
        db.update("DELETE FROM genre_relations WHERE id_m = ?", movie_id);
    }

    public void editMovie(int movie_id, Movie edited) {
            removeMovie(movie_id);
            addMovie(edited);
    }
}

