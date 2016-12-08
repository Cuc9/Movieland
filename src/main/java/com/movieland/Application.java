package com.movieland;

import com.movieland.dao.H2Dao;
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

    public void chkDB(JdbcTemplate jdbc){
        jdbc.execute("USE movieland");
        int genres_num = jdbc.queryForObject("SELECT count(*) FROM genre",Integer.class);
        System.out.println(genres_num);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = ctx.getBean(Application.class);
        H2Dao db = (H2Dao) ctx.getBean("h2Dao");
        for (Movie m:db.getAll()) {
            System.out.println(m);
        }
    }
}
