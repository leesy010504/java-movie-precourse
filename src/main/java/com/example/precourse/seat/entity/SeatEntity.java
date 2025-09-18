package com.example.precourse.seat.entity;

import java.util.Objects;

public class SeatEntity {
    private final String location;
    private final SeatGrade grade;

    public SeatEntity(String location, SeatGrade grade) {
        this.location = location;
        this.grade = grade;
    }

    public SeatGrade getGrade() {
        return grade;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatEntity seat = (SeatEntity) o;
        return Objects.equals(location, seat.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
