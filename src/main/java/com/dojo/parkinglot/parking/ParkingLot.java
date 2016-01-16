package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;

import java.util.Collections;
import java.util.List;

// TODO afmaken
//@Singleton TODO
public class ParkingLot {
    // defines the properties of the parking
    // TODO get properties from DB or property file
    private static final int nrOfGenericSpaces = 10;
    private static final int nrOfElectricSpaces = 10;
    private List<ParkingSpaceUsage> parkingSpaceUsages = Collections.emptyList();

    public boolean requestParkingSpace(Vehicle vehicle) {
        // check in the list whether a free place is available for this vehicle type
        // if available, make new usage, and add to list
        // return true, else false
        return true;
    }

    public ParkingLot() {

    }
}
