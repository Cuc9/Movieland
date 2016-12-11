package com.movieland;

import com.movieland.dao.MovieDaoH2;
import com.movieland.dbObjects.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.spel.ast.FloatLiteral;
import org.springframework.jdbc.core.JdbcTemplate;

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
        MovieDaoH2 db = (MovieDaoH2) ctx.getBean("movieDaoH2");
        Movie mov = db.getById(1);
        mov.setRaiting((float)9.2);
        mov.setPrice((float)1.15);
        System.out.println(mov);
        db.store(mov);
        /*for (Movie m:db.getAll()) {
            System.out.println(m);
        }*/
    }
}
