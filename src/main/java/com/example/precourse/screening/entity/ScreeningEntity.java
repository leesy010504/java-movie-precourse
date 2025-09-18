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
    private final List<SeatEntity> availableSeats;

    public ScreeningEntity(MovieEntity movie,  LocalDateTime startTime, TheaterEntity theater,  List<SeatEntity> availableSeats) {
        this.movie = movie;
        this.startTime = startTime;
        this.theater = theater;
        this.availableSeats = new ArrayList<>(availableSeats);
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.startTime.plusMinutes(movie.getRunningTime());
    }

    public boolean isWithinOperatingHours() {
        return theater.isWithinOperatingHours(startTime, getEndTime());
    }

    public boolean overlapsWith(ScreeningEntity other) {
        return this.getEndTime().isAfter(other.getStartTime()) &&
                this.getStartTime().isBefore(other.getEndTime());
    }

    public void reserveSeats(List<SeatEntity> seatsToReserve) {
        for (SeatEntity seatToReserve : seatsToReserve) {
            if (!this.availableSeats.contains(seatToReserve)) {
                throw new IllegalArgumentException("선택한 좌석 " + seatToReserve.getLocation() + "는 이미 예매되었거나 존재하지 않습니다.");
            }
        }

        this.availableSeats.removeAll(seatsToReserve);
    }
}
