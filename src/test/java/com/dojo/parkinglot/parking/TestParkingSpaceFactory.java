package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import com.dojo.parkinglot.users.Car;
import com.dojo.parkinglot.users.ElectricCar;
import com.dojo.parkinglot.users.Vehicle;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by oriezebos on 28-12-2015.
 */
public class TestParkingSpaceFactory {
    private Location location;

    @Before
    public void initTestVariables () {
        location = new Location();
    }

    @Test
    public void newRegularParkingSpaceShouldBeCreated () {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.GENERIC, location), is(instanceOf(RegularParkingSpace.class)));
    }

    @Test
    public void newElectricParkingSpaceShouldBeCreated () {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.ELECTRIC, location), is(instanceOf(ElectricParkingSpace.class)));
    }
}
