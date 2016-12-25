package com.movieland.dao;

import com.movieland.dbObjects.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by arpi on 25.12.2016.
 */
@Component
public class ReviewDaoH2 implements IReviewDao {
    @Autowired
    private JdbcTemplate db;

    public void addReview(Review review) {
        String sql = "INSERT INTO review (id, m_id, a_id, text) " +
                "VALUES (?, ?, ?, ?);";
        db.update(sql,review.getId(),review.getM_id(),review.getA_id(),review.getText());
    }

    public void removeReview(int review_id) {
        db.update("DELETE FROM review WHERE id = ?", review_id);
    }

    public Collection<Review> getReviewForMovie(int movie_id) {
        Collection reviews = db.query("SELECT * FROM review WHERE m_id = ?",
                (RowMapper)(resultSet, i) -> {
                Review rev = new Review();
                rev.setId(resultSet.getInt("id"));
                rev.setM_id(resultSet.getInt("m_id"));
                rev.setA_id(resultSet.getInt("a_id"));
                rev.setText(resultSet.getString("text"));
                rev.setMovie(db.queryForObject("SELECT title FROM movie WHERE id = ?", String.class, rev.getM_id()));
                rev.setAuthor(db.queryForObject("SELECT full_name FROM user WHERE id = ?", String.class, rev.getA_id()));
                return rev;
        }, movie_id);
        return reviews;
    }
}
