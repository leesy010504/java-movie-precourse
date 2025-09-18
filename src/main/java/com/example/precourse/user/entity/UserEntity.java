package com.example.precourse.user.entity;

import com.example.precourse.booking.entity.BookingEntity;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
    private final String username;
    private int points;
    private final List<BookingEntity> bookings;

    public UserEntity(String username, int points, List<BookingEntity> bookings) {
            this.username = username;
            this.points = points;
            this.bookings = new ArrayList<>();
    }

    public void addBooking(BookingEntity booking) {
        this.bookings.add(booking);
    }

    public void usePoints(int pointsToUse) {
        this.points -= pointsToUse;
    }

    public int getPoints() {
        return points;
    }
}
