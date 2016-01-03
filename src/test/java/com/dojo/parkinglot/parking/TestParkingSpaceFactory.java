package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
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
public class TestParkingSpaceFactory {

    @Autowired
    private Location location;

    @Test
    public void newRegularParkingSpaceShouldBeCreated () {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.GENERIC, location), is(instanceOf(RegularParkingSpace.class)));
    }

    @Test
    public void newElectricParkingSpaceShouldBeCreated () {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.ELECTRIC, location), is(instanceOf(ElectricParkingSpace.class)));
    }
}
