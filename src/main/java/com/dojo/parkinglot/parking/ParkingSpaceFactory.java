package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;

public class ParkingSpaceFactory {
    public static ParkingSpace createParkingSpace(ParkingSpaceTypeEnum type, Location location) {
        switch (type) {
            case ELECTRIC:
                return new PSElectric(location);
            case LARGE:
                return new PSLarge(location);
            case VISITOR:
                return new PSVisitor(location);
            case GENERIC:
                return new PSGeneric(location);
            default:
                throw new IllegalArgumentException();
        }
    }

}
