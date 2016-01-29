package com.dojo.parkinglot.model;

public class ParkingLotProperties {
    private int genericSize;

    public ParkingLotProperties() {
    }

    public int getGenericSize() {
        return genericSize;
    }

    public void setGenericSize(int genericSize) {
        this.genericSize = genericSize;
    }

    public int getElectricSize() {
        return electricSize;
    }

    public void setElectricSize(int electricSize) {
        this.electricSize = electricSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int electricSize;
    private int id;
    private String name;
}
