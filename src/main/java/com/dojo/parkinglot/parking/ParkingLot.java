package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.ElectricCar;
import com.dojo.parkinglot.users.GenericCar;
import com.dojo.parkinglot.users.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingLot {
    // defines the properties of the parking
    // TODO get properties from DB or property file
    private static final Integer nrOfGenericSpaces = 10;
    private static final Integer nrOfElectricSpaces = 10;
    private Map<Class, Integer> freeSpace = new HashMap<>();
    //private List<ParkingSpaceUsage> parkingSpaceUsages = Collections.emptyList();
    private Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsages = new HashMap<>();

    public ParkingLot() {
        freeSpace.put(ElectricCar.class, nrOfElectricSpaces);
        freeSpace.put(GenericCar.class, nrOfGenericSpaces);
    }

    public Map<Class, Integer> getFreeSpace() {
        return freeSpace;
    }

    public Map<Vehicle, ParkingSpaceUsage> getParkingSpaceUsages() {
        return parkingSpaceUsages;
    }

    public boolean requestParkingSpace(Vehicle vehicle) {
        if ( freeSpace.get(vehicle.getClass()) > 0 ) {
            freeSpace.put(vehicle.getClass(), freeSpace.get(vehicle.getClass())-1);
            parkingSpaceUsages.put(vehicle, new ParkingSpaceUsage(vehicle));
            return true;
        }
        return false;
    }

}
