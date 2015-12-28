package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

import java.util.Date;

public class ParkingSpaceUsage {

    private ParkingSpace parkingSpace;

    private Vehicle vehicle;

    private Date startUsageDateTime;

    public ParkingSpaceUsage(Vehicle vehicle, Location location) {
        this.parkingSpace = ParkingSpaceFactory.createParkingSpace(vehicle.getType(), location);
        this.startUsageDateTime = new Date();
        this.vehicle = vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartUsageDateTime() {
        return startUsageDateTime;
    }

    public Long getParkingDuration () {
        return new Date().getTime() - startUsageDateTime.getTime();
    }
}