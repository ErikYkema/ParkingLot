package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class ElectricParkingSpace extends RegularParkingSpace {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ElectricParkingSpace() {
        LOG.debug("constructor");
    }

    @Override
    public void parkVehicle(Vehicle eCar) {
        // wat is nodig om een electrische auto te parkeren
    }
}
