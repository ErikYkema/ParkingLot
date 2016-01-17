package com.dojo.parkinglot;
import com.dojo.parkinglot.parking.ParkingLot;
import com.dojo.parkinglot.parking.ParkingSpaceUsage;
import com.dojo.parkinglot.users.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Map;

public class Main {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) throws IOException{
        ParkingLot parkingLot = new ParkingLot();
        LOG.info("Hello world!");
        LOG.debug("Hello world!");
        Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsageList = parkingLot.getParkingSpaceUsages();
        LOG.info(String.format("parkingSpaceUsageList.size(): %s", parkingSpaceUsageList.size()));
        TestDerby.main(null); // TODO remove
    }
}
