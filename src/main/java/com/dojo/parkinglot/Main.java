package com.dojo.parkinglot;
import com.dojo.parkinglot.parking.ParkingLot;
import com.dojo.parkinglot.parking.ParkingSpaceUsage;
import com.dojo.parkinglot.users.Vehicle;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException{
        ParkingLot parkingLot = new ParkingLot();
        System.out.println("Hello world!");
        Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsageList = parkingLot.getParkingSpaceUsages();
        System.out.println(parkingSpaceUsageList.size());
        TestDerby.main(null); // TODO remove
    }
}
