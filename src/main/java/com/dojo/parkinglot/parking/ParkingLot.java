package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.car.ElectricCar;
import com.dojo.parkinglot.domain.car.GenericCar;
import com.dojo.parkinglot.domain.car.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

//TODO @Singleton?
public class ParkingLot {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    // defines the properties of the parking
    // TODO get properties from DB or property file
    private static final Integer nrOfGenericSpaces = 10;
    private static final Integer nrOfElectricSpaces = 10;

    private Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsages = new HashMap<>();

    private FreeSpaceCounter freeSpaceCounter = new FreeSpaceCounter();

    public ParkingLot() {
        freeSpaceCounter.setFreeSpace(ElectricCar.class, nrOfElectricSpaces);
        freeSpaceCounter.setFreeSpace(GenericCar.class, nrOfGenericSpaces);
    }

    public Map<Vehicle, ParkingSpaceUsage> getParkingSpaceUsages() {
        return parkingSpaceUsages;
    }

    public boolean requestParkingSpace(Vehicle vehicle) {
        if (freeSpaceCounter.useSpace(vehicle)) {
            parkingSpaceUsages.put(vehicle, new ParkingSpaceUsage(vehicle));
            return true;
        }
        return false;
    }

}
