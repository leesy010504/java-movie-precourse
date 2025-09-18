package com.example.precourse.payment.entity;

public enum PaymentMethod {
    CREDIT_CARD(0.05),
    CASH(0.02);

    private final double discountRate;

    PaymentMethod(double discountRate) {
        this.discountRate = discountRate;
    }
}
