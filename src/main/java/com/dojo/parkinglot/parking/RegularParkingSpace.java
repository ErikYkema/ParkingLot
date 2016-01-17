package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class RegularParkingSpace implements ParkingSpace {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public RegularParkingSpace() {

    }

    @Override
    public void parkVehicle(Vehicle car) {
        // wat is nodig om een reguliere auto te parkeren

    }

}
