package com.dojo.parkinglot.parking;

import java.util.Date;

public class ParkingSpace {
    private Location location;
    private Date startUsageDateTime; // TODO move to class ParkingSpaceUsage?
    private boolean isInUse; // idem

    public ParkingSpace() {
    }

    public ParkingSpace(Location location) {
        this.location = location;
    }
}
