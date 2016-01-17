package com.dojo.parkinglot.domain.car;

import com.dojo.parkinglot.domain.parkingspace.ParkingSpaceTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

    //TODO type is double now, remove (or use getClass())
    @Test
    public void newGenericCarShouldHaveCorrectType() {
        assertThat(car.getType().equals(ParkingSpaceTypeEnum.GENERIC), is(true));
    }
}
