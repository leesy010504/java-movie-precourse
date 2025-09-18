package com.example.precourse.booking.entity;

import com.example.precourse.reservation.entity.ReservationEntity;
import com.example.precourse.user.entity.UserEntity;
import java.math.BigDecimal;
import java.util.List;

public class BookingEntity {
    private UserEntity user;
    private final List<ReservationEntity> reservations;
    private final BigDecimal finalPrice;

    public BookingEntity(UserEntity user, List<ReservationEntity> reservations, BigDecimal finalPrice) {
        this.user = user;
        this.reservations = reservations;
        this.finalPrice = finalPrice;
    }
}
