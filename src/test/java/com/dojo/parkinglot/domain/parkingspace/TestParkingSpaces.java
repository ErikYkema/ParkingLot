package com.dojo.parkinglot.domain.parkingspace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestParkingSpaces {

    @Autowired
    RegularParkingSpace regularParkingSpace;

    @Test
    public void testParkingSpace() {
        assertNotNull(regularParkingSpace);

    }
}
