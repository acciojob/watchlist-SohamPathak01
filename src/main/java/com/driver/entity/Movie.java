package com.driver.entity;
import java.lang.String;

import org.springframework.stereotype.Repository;

public class Movie {
    private String MovieName;
    private String MovieDirector;

    public Movie(String movieName,String MovieDirector) {
        this.MovieName = movieName;
        this.MovieDirector=MovieDirector;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getMovieDirector() {
        return MovieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        MovieDirector = movieDirector;
    }
}
