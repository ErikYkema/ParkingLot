package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import com.dojo.parkinglot.users.ElectricCar;
import com.dojo.parkinglot.users.GenericCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by oriezebos on 28-12-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestCarTypes {

    @Autowired
    private ElectricCar electricCar;

    @Test
    public void newElectricCarShouldHaveCorrectType() {
        assertThat(electricCar.getType().equals(ParkingSpaceTypeEnum.ELECTRIC), is(true));
    }

    @Autowired
    private GenericCar car;

    //TODO type is double now, remove (use instanceof())
    @Test
    public void newGenericCarShouldHaveCorrectType() {
        assertThat(car.getType().equals(ParkingSpaceTypeEnum.GENERIC), is(true));
    }
}
