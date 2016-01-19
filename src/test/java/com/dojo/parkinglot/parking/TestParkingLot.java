package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.car.GenericCar;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.invoke.MethodHandles;
import java.util.Date;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestParkingLot {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    ParkingLot parkingLot = ParkingLot.getParkingLot();
    @Autowired
    GenericCar car;

    // integration test
    @Test
    public void testUsage() {
        LOG.info ("start");
        for (int i=0; i<5; i++) {
            GenericCar car = new GenericCar(new Date().toString());
            assertTrue("cannot get parking space", parkingLot.requestParkingSpace(car));
            LOG.info(ToStringBuilder.reflectionToString(parkingLot.getFreeSpaceCounter()));
            LOG.info(String.format("nr of usages: %s", parkingLot.getParkingSpaceUsages().size()));
            LOG.info(ToStringBuilder.reflectionToString(parkingLot.getParkingSpaceUsages().get(car)));
            try {
                // sleep to get different usage (time) values
                Thread.sleep(1000L); // millis
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOG.info(String.format("parked duration: %s", parkingLot.getParkingSpaceUsages().get(car).getParkingDuration()));
        }
    }
}
