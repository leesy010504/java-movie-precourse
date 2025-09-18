package com.example.precourse.screening.entity;

import com.example.precourse.movie.entity.MovieEntity;
import com.example.precourse.seat.entity.SeatEntity;
import com.example.precourse.theater.entity.TheaterEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningEntity {
    private MovieEntity movie;
    private LocalDateTime startTime;
    private TheaterEntity theater;
    private List<SeatEntity> bookedSeats = new ArrayList<>();

    public ScreeningEntity(MovieEntity movie,  LocalDateTime startTime, TheaterEntity theater) {
        this.movie = movie;
        this.startTime = startTime;
        this.theater = theater;
    }
}
