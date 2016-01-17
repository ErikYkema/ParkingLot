package com.dojo.parkinglot.domain.parkingspace;

import com.dojo.parkinglot.domain.car.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ElectricParkingSpace extends RegularParkingSpace {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ElectricParkingSpace() {
    }

    @Override
    public void parkVehicle(Vehicle eCar) {
        // wat is nodig om een electrische auto te parkeren
    }
}
