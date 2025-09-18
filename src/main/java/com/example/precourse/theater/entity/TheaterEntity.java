package com.example.precourse.theater.entity;

public class TheaterEntity {
    private final String name;
    private final int openTime;
    private final int closeTime; // 운영시간은 0~23시 안으로 가정합니다.

    public TheaterEntity(String name, int openTime, int closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
}
