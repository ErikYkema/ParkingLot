package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import com.dojo.parkinglot.users.Car;

public class ParkingSpaceFactory {
    public static ParkingSpace createParkingSpace(ParkingSpaceTypeEnum type, Location location) {
        switch (type) {
            case GENERIC:
                return new RegularParkingSpace(location);
            case ELECTRIC:
                return new ElectricParkingSpace(location);
//            case LARGE: TODO extend?
//                return new PSLarge(location);
//            case VISITOR:
//                return new PSVisitor(lcoation);
            default:
                throw new IllegalArgumentException();
        }

    }

}
