package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;

public class ParkingSpaceFactory {
    public static ParkingSpace createParkingSpace(ParkingSpaceTypeEnum type) {
        switch (type) {
        case GENERIC:
            return new RegularParkingSpace();
        case ELECTRIC:
            return new ElectricParkingSpace();
//            case LARGE: TODO extend?
//                return new PSLarge(location);
//            case VISITOR:
//                return new PSVisitor(lcoation);
        default:
            throw new IllegalArgumentException();
        }

    }

}
