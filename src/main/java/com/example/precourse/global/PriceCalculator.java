package com.example.precourse.global;

import com.example.precourse.payment.entity.PaymentMethod;
import com.example.precourse.reservation.entity.ReservationEntity;
import com.example.precourse.screening.entity.ScreeningEntity;
import com.example.precourse.seat.entity.SeatEntity;
import java.util.List;

public class PriceCalculator {

    private static final int TIME_DISCOUNT_AMOUNT = 2000;
    private static final double DAY_DISCOUNT_PERCENT = 0.1;

    public int calculateFinalPrice(List<ReservationEntity> reservations, int pointsToUse, PaymentMethod paymentMethod) {
        int totalDiscountedPrice = 0;
        for (ReservationEntity reservation : reservations) {
            totalDiscountedPrice += calculatePrice(reservation);
        }

        int priceAfterPoints = totalDiscountedPrice - pointsToUse;
        return applyPaymentMethodDiscount(priceAfterPoints, paymentMethod);
    }

    private int calculatePrice(ReservationEntity reservation) {
        int basePrice = calculateBasePrice(reservation.getSeats());
        ScreeningEntity screening = reservation.getScreening();
        int priceAfterMovieDay = applyMovieDayDiscount(basePrice, screening);

        return applyTimeDiscount(priceAfterMovieDay, screening);
    }

    private int calculateBasePrice(List<SeatEntity> seats) {
        int total = 0;
        for (SeatEntity seat : seats) {
            total += seat.getGrade().getPrice();
        }
        return total;
    }

    private int applyMovieDayDiscount(int price, ScreeningEntity screening) {
        int day = screening.getStartTime().getDayOfMonth();
        boolean isMovieDay = (day == 10 || day == 20 || day == 30);

        if (isMovieDay) {
            return (int) (price * (1.0 - DAY_DISCOUNT_PERCENT));
        }
        return price;
    }

    private int applyTimeDiscount(int price, ScreeningEntity screening) {
        int hour = screening.getStartTime().getHour();
        boolean isTimeDiscount = (hour < 11 || hour >= 20);

        if (isTimeDiscount) {
            return price - TIME_DISCOUNT_AMOUNT;
        }
        return price;
    }

    private int applyPaymentMethodDiscount(int price, PaymentMethod paymentMethod) {
        return (int) (price * (1 - paymentMethod.getDiscountRate()));
    }
}

