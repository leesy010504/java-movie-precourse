package com.example.precourse.booking.entity;

import com.example.precourse.reservation.entity.ReservationEntity;
import com.example.precourse.user.entity.UserEntity;
import java.util.List;

public class BookingEntity {
    private UserEntity user;
    private final List<ReservationEntity> reservations;
    private final int finalPrice;

    public BookingEntity(UserEntity user, List<ReservationEntity> reservations, int finalPrice) {
        this.user = user;
        this.reservations = reservations;
        this.finalPrice = finalPrice;
    }
}
