package com.movieland.dbObjects;

import org.springframework.stereotype.Component;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
        System.out.println("Genre was created");
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
