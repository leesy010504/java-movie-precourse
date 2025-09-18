package com.example.precourse.reservation.entity;

import com.example.precourse.screening.entity.ScreeningEntity;
import com.example.precourse.seat.entity.SeatEntity;

import java.util.List;

public class ReservationEntity {
    private final ScreeningEntity screening;
    private final List<SeatEntity> seats;

    public ReservationEntity(ScreeningEntity screening, List<SeatEntity> seats) {
        this.screening = screening;
        this.seats = seats;
    }

    public ScreeningEntity getScreening() {
        return screening;
    }

    public List<SeatEntity> getSeats() {
        return seats;
    }
}
