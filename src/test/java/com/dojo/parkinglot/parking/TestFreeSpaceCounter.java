package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.domain.car.ElectricCar;
import com.dojo.parkinglot.domain.car.GenericCar;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class TestFreeSpaceCounter {

    @Autowired
    FreeSpaceCounter freeSpaceCounter;
    @Autowired
    GenericCar car;
    @Autowired
    ElectricCar eCar;

    private static final Integer NR_OF_CARS = 10;
    private static final Integer NR_OF_ECARS = 5;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        freeSpaceCounter.setFreeSpace(ElectricCar.class, NR_OF_ECARS);
        freeSpaceCounter.setFreeSpace(GenericCar.class, NR_OF_CARS);
    }

    @Test
    public void testFreeSpaceCounterSize() {
        assertThat("size of counter", freeSpaceCounter.getFreeSpace(car), is(NR_OF_CARS));
        assertThat("size of counter", freeSpaceCounter.getFreeSpace(eCar), is(NR_OF_ECARS));
    }

    @Test
    public void testFreeSpaceCounterUse() {
        freeSpaceCounter.useSpace(car);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(car), is(NR_OF_CARS - 1));
        freeSpaceCounter.useSpace(car);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(car), is(NR_OF_CARS - 2));

        freeSpaceCounter.useSpace(eCar);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(eCar), is(NR_OF_ECARS - 1));
        freeSpaceCounter.useSpace(eCar);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(eCar), is(NR_OF_ECARS - 2));
    }

    @Test
    public void testFreeSpaceCounterRelease() {
        freeSpaceCounter.useSpace(car);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(car), is(NR_OF_CARS - 1));
        freeSpaceCounter.release(car);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(car), is(NR_OF_CARS));

        freeSpaceCounter.useSpace(eCar);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(eCar), is(NR_OF_ECARS - 1));
        freeSpaceCounter.release(eCar);
        assertThat("use a car", freeSpaceCounter.getFreeSpace(eCar), is(NR_OF_ECARS));
    }

    @Test
    public void testFreeSpaceCounterReleaseError() {
        exception.expect(RuntimeException.class);
        freeSpaceCounter.release(car);
    }
}

