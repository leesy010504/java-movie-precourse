package com.example.precourse.theater.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TheaterEntity {
    private final String name;
    private final int openTime;
    private final int closeTime; // 운영시간은 0~23시 안으로 가정합니다.

    public TheaterEntity(String name, int openTime, int closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public boolean isWithinOperatingHours(LocalDateTime start, LocalDateTime end) {
        LocalTime screeningStart = start.toLocalTime();
        LocalTime screeningEnd = end.toLocalTime();
        LocalTime operatingStart = LocalTime.of(openTime, 0);
        LocalTime operatingEnd = LocalTime.of(closeTime, 0);
        boolean startsOnOrAfterOpening = !screeningStart.isBefore(operatingStart);
        boolean endsOnOrBeforeClosing = !screeningEnd.isAfter(operatingEnd);

        return startsOnOrAfterOpening && endsOnOrBeforeClosing;
    }
}
