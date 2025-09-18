package com.example.precourse.booking.entity;

import com.example.precourse.payment.entity.PaymentMethod;
import com.example.precourse.screening.entity.ScreeningEntity;
import com.example.precourse.seat.entity.SeatEntity;
import com.example.precourse.user.entity.UserEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class BookingEntity {
    private UserEntity user;
    private Map<ScreeningEntity, List<SeatEntity>> bookingInfo;
    private PaymentMethod paymentMethod;
    private final BigDecimal finalPrice;

    public BookingEntity(UserEntity user, Map<ScreeningEntity, List<SeatEntity>> bookingInfo, BigDecimal finalPrice,  PaymentMethod paymentMethod) {
        this.user = user;
        this.bookingInfo = bookingInfo;
        this.finalPrice = finalPrice;
        this.paymentMethod = paymentMethod;
    }
}
