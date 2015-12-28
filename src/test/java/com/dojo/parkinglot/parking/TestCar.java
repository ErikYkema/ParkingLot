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
public class TestCar {
    private Car car;

    @Before
    public void initTestVariables () {
        car = new Car();
    }

    @Test
    public void newCarShouldHaveRegularType() {
        assertThat(car.getType().equals(ParkingSpaceTypeEnum.GENERIC), is(true));
    }
}
