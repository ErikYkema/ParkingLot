package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.parkingspace.ElectricParkingSpace;
import com.dojo.parkinglot.domain.parkingspace.ParkingSpace;
import com.dojo.parkinglot.domain.parkingspace.ParkingSpaceTypeEnum;
import com.dojo.parkinglot.domain.parkingspace.RegularParkingSpace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ParkingSpaceFactory {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
