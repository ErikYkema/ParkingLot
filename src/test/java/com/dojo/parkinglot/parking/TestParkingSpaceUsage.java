package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Car;
import com.dojo.parkinglot.users.ElectricCar;
import com.dojo.parkinglot.users.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by oriezebos on 28-12-2015.
 */
public class TestParkingSpaceUsage {
    private Location location;
    private Vehicle vehicle;

    @Before
    public void initTestVariables () {
        location = new Location();
    }

    @Test
    public void newParkingSpaceUsageShouldBeCreated () {
        vehicle = new Car();
        Long duration = 100L;
        ParkingSpaceUsage parkingSpaceUsage = new ParkingSpaceUsage(vehicle, location);
        try {
            Thread.sleep(duration);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        assertThat(parkingSpaceUsage.getParkingDuration(), is(duration));
        assertThat(parkingSpaceUsage.getParkingSpace(), is(instanceOf(RegularParkingSpace.class)));
        assertThat(parkingSpaceUsage.getVehicle(), is(vehicle));
    }
}
