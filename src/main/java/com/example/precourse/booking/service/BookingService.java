package com.example.precourse.booking.service;

import com.example.precourse.booking.entity.BookingEntity;
import com.example.precourse.global.PriceCalculator;
import com.example.precourse.payment.entity.PaymentMethod;
import com.example.precourse.reservation.entity.ReservationEntity;
import com.example.precourse.screening.entity.ScreeningEntity;
import com.example.precourse.user.entity.UserEntity;

import java.util.Comparator;
import java.util.List;

public class BookingService {

    private final PriceCalculator priceCalculator;

    public BookingService() {
        this.priceCalculator = new PriceCalculator();
    }

    public BookingEntity createBooking(UserEntity user, List<ReservationEntity> reservations, int pointsToUse, PaymentMethod paymentMethod) {
        validateReservations(user, reservations, pointsToUse);

        for (ReservationEntity reservation : reservations) {
            reservation.getScreening().reserveSeats(reservation.getSeats());
        }

        int finalPrice = priceCalculator.calculateFinalPrice(reservations, pointsToUse, paymentMethod);
        BookingEntity booking = new BookingEntity(user, reservations, finalPrice);

        user.addBooking(booking);
        user.usePoints(pointsToUse);

        return booking;
    }

    private void validateReservations(UserEntity user, List<ReservationEntity> reservations, int pointsToUse) {
        if (user.getPoints() < pointsToUse) {
            throw new IllegalArgumentException("보유 포인트가 부족합니다.");
        }
        if (hasOverlappingScreenings(reservations)) {
            throw new IllegalArgumentException("상영 시간이 겹칩니다.");
        }
        for (ReservationEntity reservation : reservations) {
            if (!reservation.getScreening().isWithinOperatingHours()) {
                throw new IllegalArgumentException("상영관 운영 시간이 아닙니다.");
            }
        }
    }

    private boolean hasOverlappingScreenings(List<ReservationEntity> reservations) {
        if (reservations.size() <= 1) {
            return false;
        }

        reservations.sort(Comparator.comparing(r -> r.getScreening().getStartTime()));

        for (int i = 0; i < reservations.size() - 1; i++) {
            ScreeningEntity current = reservations.get(i).getScreening();
            ScreeningEntity next = reservations.get(i + 1).getScreening();

            if (current.overlapsWith(next)) {
                return true;
            }
        }
        return false;
    }
}
