package com.movieland.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by arpi on 05.01.2017.
 */
public class Index extends HttpServlet {
    public Index() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");*/

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
