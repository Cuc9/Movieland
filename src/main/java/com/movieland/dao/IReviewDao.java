package com.movieland.dao;

import com.movieland.dbObjects.Review;

import java.util.Collection;

/**
 * Created by arpi on 25.12.2016.
 */
public interface IReviewDao {

    void addReview(Review review);

    void removeReview(int review_id);

    Collection<Review> getReviewForMovie(int movie_id);
}
