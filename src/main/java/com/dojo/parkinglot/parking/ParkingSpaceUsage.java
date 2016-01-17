package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Date;

public class ParkingSpaceUsage {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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