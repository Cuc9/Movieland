package com.movieland;

import com.movieland.dao.MockDao;
import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

/**
 * Created by arpi on 04.12.2016.
 */
public class Application {

    @Autowired
    private static JdbcTemplate jdbc;

    @Autowired
    public void chkDB(JdbcTemplate jdbc){
        int genres_num = jdbc.queryForObject("SELECT count(*) FROM GENRE",Integer.class);
        System.out.println(genres_num);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = ctx.getBean(Application.class);
        app.chkDB(jdbc);
    }
}
