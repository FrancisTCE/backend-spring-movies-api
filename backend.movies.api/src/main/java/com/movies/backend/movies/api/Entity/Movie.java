package com.movies.backend.movies.api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOVIEDB")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name="movie_year")
    private int movieYear;
    @Column(name="rating")
    private int rating;
    @Column(name="name")
    private String name;

    

    public Movie() {
        super();
    }



    public Movie(long iD, int movieYear, int rating, String name) {
        ID = iD;
        this.movieYear = movieYear;
        this.rating = rating;
        this.name = name;
    }

    

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public int getmovieYear() {
        return movieYear;
    }

    public void setmovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
