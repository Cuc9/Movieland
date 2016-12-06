package com.movieland.dbObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class Movie {
    private int id;
    private  String title;
    private int year;
    private String country;
    @Autowired
    private List<Genre> genres;
    private String description;
    private float raiting;
    private float price;

    public Movie() {
        System.out.println("Movie created");
    }

    /*@PostConstruct
    private void init(){
        this.id = 1;
        title = "aaa";
        year = 1111;
        country = "UA";
        System.out.println("Movie init done");
    }*/

    public void setId(int id) {
        this.id = id;
    }

    /*public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public void setPrice(float price) {
        this.price = price;
    }*/

}
