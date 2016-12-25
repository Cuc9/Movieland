package com.movieland.dbObjects;

import com.movieland.dao.IReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class Review{
    private int id;
    private int m_id;
    private int a_id;
    private String text;

    private String movie;
    private String author;

    @Autowired
    JdbcTemplate db;

    public int getId() {
        return id;
    }

    public int getM_id() {
        return m_id;
    }

    public int getA_id() {
        return a_id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNewId() {
        Integer max_id = db.queryForObject("SELECT MAX (id) FROM review",Integer.class);
        this.id = ++max_id;
    }

    @Override
    public String toString() {
        return "Review for movie: " + movie + "\n"
                + "Author: " + author + "\n"
                + text + "\n";
    }
}
