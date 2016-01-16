package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

import java.util.Date;

public class ParkingSpaceUsage {

    private ParkingSpace parkingSpace;

    private Date startUsageDateTime;

    public ParkingSpaceUsage(Vehicle vehicle) {
        this.parkingSpace = ParkingSpaceFactory.createParkingSpace(vehicle.getType());
        this.startUsageDateTime = new Date();
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public Date getStartUsageDateTime() {
        return startUsageDateTime;
    }

    public Long getParkingDuration() {
        return new Date().getTime() - startUsageDateTime.getTime();
    }
}