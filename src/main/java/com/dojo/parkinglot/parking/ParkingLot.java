package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.car.ElectricCar;
import com.dojo.parkinglot.domain.car.GenericCar;
import com.dojo.parkinglot.domain.car.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ejb.Startup;
import javax.inject.Singleton;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@Startup
@Component
@Singleton
public class ParkingLot {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    // defines the properties of the parking
    // TODO get properties from DB or property file
    private static final Integer nrOfGenericSpaces = 3;
    private static final Integer nrOfElectricSpaces = 2;

    // TODO @Autowired
    private FreeSpaceCounter freeSpaceCounter = new FreeSpaceCounter();
    public FreeSpaceCounter getFreeSpaceCounter() {
        return freeSpaceCounter;
    }

    private Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsages = new HashMap<>();
    public Map<Vehicle, ParkingSpaceUsage> getParkingSpaceUsages() {
        return parkingSpaceUsages;
    }

    // singleton pattern implementation
    private static ParkingLot parkingLot;
    public static ParkingLot getParkingLot() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    private ParkingLot() {
        LOG.info("constructor");
        freeSpaceCounter.setFreeSpace(ElectricCar.class, nrOfElectricSpaces);
        freeSpaceCounter.setFreeSpace(GenericCar.class, nrOfGenericSpaces);
    }

    public boolean requestParkingSpace(Vehicle vehicle) {
        if (freeSpaceCounter.useSpace(vehicle)) {
            parkingSpaceUsages.put(vehicle, new ParkingSpaceUsage(vehicle));
            return true;
        }
        return false;
    }

}
