package com.dojo.parkinglot.users;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;

/**
 * Created by oriezebos on 28-12-2015.
 */
public class ElectricCar implements Vehicle {
    private final ParkingSpaceTypeEnum type = ParkingSpaceTypeEnum.ELECTRIC;
    private String licensePlate;

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
