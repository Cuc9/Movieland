package com.movieland.dao;

import com.movieland.dbObjects.Genre;
import com.sun.xml.internal.ws.api.server.InstanceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arpi on 10.12.2016.
 */
@Component
public class GenreDaoH2 {

    @Autowired
    private JdbcTemplate db;
    private Map<Integer,Genre> genres;

    public GenreDaoH2() {
        System.out.println("GenreDao created");
    }

    @PostConstruct
    private void init(){
        System.out.println("DB is " + db);
        List<Genre> genresList = db.query("SELECT * FROM genre",
                new RowMapper<Genre>() {
            public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Genre(id, name);
            }
        });

        genres = new HashMap<Integer, Genre>();
        for (Genre g : genresList) {
            genres.put(g.getId(),g);
        }
        System.out.println("Genres Map created");
    }

    public Genre getGenre(Integer id){
        if (genres == null){init();}
        return genres.get(id);
    }
}
