package com.movieland;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movieland.dao.MovieDaoH2;
import com.movieland.dbObjects.Genre;
import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpi on 05.01.2017.
 */
@Controller
@RequestMapping("/movieland")
public class MovielandController {
    @Autowired
    private MovieDaoH2 movDao;

    @RequestMapping(path = "/v1", method = RequestMethod.GET)
    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");*/
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
    }

    @RequestMapping(path = "v1/movies", method = RequestMethod.GET)
    public void allMovies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> allMovies = movDao.getAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String out = "";
        for (Movie elem:allMovies) {
            out = out.concat(gson.toJson(elem.getTitle()));
            out = out.concat("\n");
            out = out.concat(gson.toJson(elem.getYear()));
            out = out.concat("\n");
            out = out.concat(gson.toJson(elem.getRaiting()));
            out = out.concat("\n");
            List<String> gNames = new ArrayList<>();
            for (Genre genre:elem.getGenres()) {
                gNames.add(genre.getName());
            }
            out = out.concat(gson.toJson(gNames));
            out = out.concat("\n\n");
        }
        resp.setHeader("contentType", "charset=UTF-8");
        resp.getWriter().write(out);
    }

}
