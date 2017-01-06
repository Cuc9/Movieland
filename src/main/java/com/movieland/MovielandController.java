package com.movieland;

import com.movieland.dao.MovieDaoH2;
import com.movieland.dbObjects.Movie;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");
        //req.getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
    }

    @RequestMapping(path = "v1/movies", method = RequestMethod.GET)
    public void allMovies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> allMovies = movDao.getAll();
        resp.getWriter().write(allMovies.toString());
    }

}
