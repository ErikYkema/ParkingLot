package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by oriezebos on 28-12-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestParkingSpaceUsage {

    @Autowired
    private Location location;

    @Autowired
    private Car car;

    @Test
    public void newParkingSpaceUsageShouldBeCreated () {
        Long duration = 100L;
        ParkingSpaceUsage parkingSpaceUsage = new ParkingSpaceUsage(car, location);
        try {
            Thread.sleep(duration);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        assertThat(parkingSpaceUsage.getParkingDuration(), is(duration));
        assertThat(parkingSpaceUsage.getParkingSpace(), is(instanceOf(RegularParkingSpace.class)));
        assertThat(parkingSpaceUsage.getVehicle(), is(car));
    }
}
