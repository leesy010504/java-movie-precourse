package com.example.precourse.seat.entity;

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
}
