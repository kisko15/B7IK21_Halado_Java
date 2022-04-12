package org.example.dto;

public class Result {

    private String name;
    private double point;

    public Result(String name, double point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }
}
