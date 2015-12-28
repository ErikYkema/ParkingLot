package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

public class ElectricParkingSpace extends RegularParkingSpace {

    public ElectricParkingSpace(Location location) {
        super(location);
    }

    @Override
    public void parkVehicle(Vehicle eCar) {
        // wat is nodig om een electrische auto te parkeren
    }
}
