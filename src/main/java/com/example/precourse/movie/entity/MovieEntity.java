package com.example.precourse.movie.entity;

public class MovieEntity {
    private String title;
    private final int runningTime;

    public MovieEntity(String title, int runningTime) {
        this.title = title;
        this.runningTime = runningTime;
    }
}
