package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import com.dojo.parkinglot.users.Car;
import com.dojo.parkinglot.users.ElectricCar;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by oriezebos on 28-12-2015.
 */
public class TestElectricCar {
    private ElectricCar electricCar;

    @Before
    public void initTestVariables () {
        electricCar = new ElectricCar();
    }

    @Test
    public void newCarShouldHaveRegularType() {
        assertThat(electricCar.getType().equals(ParkingSpaceTypeEnum.ELECTRIC), is(true));
    }
}
