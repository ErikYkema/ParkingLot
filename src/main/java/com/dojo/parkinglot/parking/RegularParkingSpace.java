package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

public class RegularParkingSpace implements ParkingSpace {

    private Location location;

    public RegularParkingSpace(Location location) {
        this.location = location;
    }

    @Override
    public void parkVehicle(Vehicle car) {
        // wat is nodig om een reguliere auto te parkeren

    }

}
