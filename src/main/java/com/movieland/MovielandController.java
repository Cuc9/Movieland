package com.movieland;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movieland.dao.MovieDaoH2;
import com.movieland.dao.ReviewDaoH2;
import com.movieland.dbObjects.Genre;
import com.movieland.dbObjects.Movie;
import com.movieland.dbObjects.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by arpi on 05.01.2017.
 */
@Controller
@RequestMapping("/movieland/v1")
public class MovielandController {
    @Autowired
    private MovieDaoH2 movDao;
    @Autowired
    private ReviewDaoH2 reviewDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");*/
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movies")
    public void allMovies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> allMovies = movDao.getAll();
        resp.setHeader("contentType", "text/html; charset=UTF-8");
        resp.setHeader("Content-Language", "en, ru");
        System.out.println(allMovies);
        resp.getWriter().write(allMoviesToJson(allMovies));
    }


    @RequestMapping(method = RequestMethod.GET, path = "/movie/{id}")
    public void movieById(@PathVariable("id") int id, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Review> reviews = reviewDao.getReviewForMovie(id);
        Writer wr = resp.getWriter();
        wr.write(movieToJson(movDao.getById(id)));
        Iterator<Review> it = reviews.iterator();
        int i = 0;
        while (it.hasNext() && i < 2){
            wr.write(it.next().toString());
            i++;
        }
    }


    private String allMoviesToJson(List<Movie> movies) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String out = "";
        for (Movie elem : movies) {
            out = out.concat(gson.toJson(elem.getTitle()));
            out = out.concat("\n");
            out = out.concat(gson.toJson(elem.getYear()));
            out = out.concat("\n");
            out = out.concat(gson.toJson(elem.getRaiting()));
            out = out.concat("\n");
            List<String> gNames = new ArrayList<>();
            for (Genre genre : elem.getGenres()) {
                gNames.add(genre.getName());
            }
            out = out.concat(gson.toJson(gNames));
            out = out.concat("\n\n");
        }
        return out;
    }

    private String movieToJson(Movie movie) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String out = "";
        out = out.concat(gson.toJson(movie.getTitle()));
        out = out.concat("\n");
        out = out.concat(gson.toJson(movie.getYear()));
        out = out.concat("\n");
        out = out.concat(gson.toJson(movie.getCountry()));
        out = out.concat("\n");
        List<String> gNames = new ArrayList<>();
        for (Genre genre : movie.getGenres()) {
            gNames.add(genre.getName());
        }
        out = out.concat(gson.toJson(gNames));
        out = out.concat("\n");
        out = out.concat(gson.toJson(movie.getDescription()));
        out = out.concat("\n");
        out = out.concat(gson.toJson(movie.getRaiting()));
        out = out.concat("\n");
        return out;
    }

}
