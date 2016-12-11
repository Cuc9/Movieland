package com.movieland.dbObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private List<Genre> genres;
    private String description;
    private float raiting;
    private float price;
    @Autowired
    private static JdbcTemplate db;

    public Movie() {
       // setNewId();
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getDescription() {
        return description;
    }

    public float getRaiting() {
        return raiting;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNewId() {
        Integer id = db.queryForObject("SELECT MAX(id) FROM movie",Integer.class);
        this.id = ++id;
    }

    public void setTitle(String title) {
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
    }

    @Override
    public String toString() {
        return title + '\n' +
               year + '\n' +
               country + '\n' +
               genres + '\n' +
               description +'\n' +
               raiting + '\n' +
               price + '$' + '\n';
    }

}
