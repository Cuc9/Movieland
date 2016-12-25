package com.movieland;

import com.movieland.dao.GenreDaoH2;
import com.movieland.dao.MovieDaoH2;
import com.movieland.dao.ReviewDaoH2;
import com.movieland.dbObjects.Genre;
import com.movieland.dbObjects.Movie;
import com.movieland.dbObjects.Review;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.spel.ast.FloatLiteral;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        MovieDaoH2 movieDaoH2 = (MovieDaoH2) ctx.getBean("movieDaoH2");
        Movie mov = (Movie) ctx.getBean("movie");
        Review review = (Review) ctx.getBean("review");

        ReviewDaoH2 rd = (ReviewDaoH2) ctx.getBean("reviewDaoH2");
        Collection reviews = rd.getReviewForMovie(1);
        System.out.println(reviews);
        //rd.removeReview(8);

        /*mov.setTitle("Матрица/Matrix");
        mov.setYear(2000);
        mov.setCountry("USA");
        mov.setPrice(0.8f);
        mov.setRaiting(7.5f);
        mov.setDescription("Very good film with Kiano Reeves");
        GenreDaoH2 genres = (GenreDaoH2) ctx.getBean("genreDaoH2");
        List<Genre> g = new ArrayList<Genre>();
        g.add(genres.getGenreByName("фантастика"));
        g.add(genres.getGenreByName("боевик"));
        mov.setGenres(g);
        System.out.println(mov);
        mov.setNewId();
        movieDaoH2.addMovie(mov);*/

        ///mov.setYear(2000);


        //movieDaoH2.removeMovie(6);
        //movieDaoH2.addMovie(mov);
    }
}
