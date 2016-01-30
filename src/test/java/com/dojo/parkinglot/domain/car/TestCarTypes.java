package com.dojo.parkinglot.domain.car;

import com.dojo.parkinglot.domain.parkingspace.ParkingSpaceTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.invoke.MethodHandles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestCarTypes {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String licensePlate = "AA-001-001";

    @Autowired
    private GenericCar car;

    //TODO type is double now, remove (or use getClass())
    @Test
    public void newGenericCarShouldHaveCorrectType() {
        assertThat(car.getType().equals(ParkingSpaceTypeEnum.GENERIC), is(true));
        car.setLicensePlate(licensePlate);
        assertThat("incorrect license plate", car.getLicensePlate(), is(licensePlate));
    }

    @Autowired
    private ElectricCar electricCar;

    @Test
    public void newElectricCarShouldHaveCorrectType() {
        assertThat(electricCar.getType().equals(ParkingSpaceTypeEnum.ELECTRIC), is(true));

    }

}
