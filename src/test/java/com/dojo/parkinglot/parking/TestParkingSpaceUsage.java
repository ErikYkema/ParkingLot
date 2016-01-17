package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.parkingspace.RegularParkingSpace;
import com.dojo.parkinglot.domain.cars.GenericCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestParkingSpaceUsage {

    @Autowired
    private GenericCar car;

    @Test
    public void assertThatNewParkingSpaceCountsDuration() {
        Long duration = 100L;
        ParkingSpaceUsage parkingSpaceUsage = new ParkingSpaceUsage(car);
        try {
            Thread.sleep(duration);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        assertTrue(parkingSpaceUsage.getParkingDuration()>=duration);
        assertThat(parkingSpaceUsage.getParkingSpace(), is(instanceOf(RegularParkingSpace.class)));
    }
}
