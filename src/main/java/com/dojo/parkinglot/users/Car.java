package com.dojo.parkinglot.users;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;

public class Car implements Vehicle {
    private final ParkingSpaceTypeEnum type = ParkingSpaceTypeEnum.GENERIC;
    private String licensePlate;

    public Car() {
    }

    @Override
    public ParkingSpaceTypeEnum getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
