package com.movieland.servlet;

import com.movieland.dao.MovieDaoH2;
import com.movieland.dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by arpi on 28.12.2016.
 */
@Component
public class AllMovies extends HttpServlet {

    @Autowired
    private MovieDaoH2 movDao;

    public AllMovies() {super();    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> allMovies = movDao.getAll();
        resp.getWriter().write(allMovies.toString());
    }
}
