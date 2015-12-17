package com.dojo.parkinglot.parking;

public class Location {

    private String building = "";
    private int number = 0;

    public Location() {

    }

    public Location(String building, int number) {
        this.building = building;
        this.number = number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
