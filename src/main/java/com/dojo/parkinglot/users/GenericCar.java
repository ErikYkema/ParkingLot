package com.dojo.parkinglot.users;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class GenericCar implements Vehicle {
    private final ParkingSpaceTypeEnum type = ParkingSpaceTypeEnum.GENERIC;
    private String licensePlate;

    public GenericCar() {
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
