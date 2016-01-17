package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.ParkingSpaceTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestParkingSpaceFactory {

    @Test
    public void newRegularParkingSpaceShouldBeCreated() {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.GENERIC),
                is(instanceOf(RegularParkingSpace.class)));
    }

    @Test
    public void newElectricParkingSpaceShouldBeCreated() {
        assertThat(ParkingSpaceFactory.createParkingSpace(ParkingSpaceTypeEnum.ELECTRIC),
                is(instanceOf(ElectricParkingSpace.class)));
    }
}
