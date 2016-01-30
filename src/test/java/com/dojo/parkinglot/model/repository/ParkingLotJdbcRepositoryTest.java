package com.dojo.parkinglot.model.repository;

import com.dojo.parkinglot.model.ParkingLotProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.invoke.MethodHandles;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class ParkingLotJdbcRepositoryTest {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    ParkingLotJdbcRepository repository;
    @Autowired
    ParkingLotProperties properties;

    @Before
    public void setUp() throws Exception {
        repository.setup(ParkingLotJdbcRepository.Feature.DROP_AND_CREATE);
    }

    @Test
    public void testSavePropertiesGetById() throws Exception {
        properties.setName("Foo");
        properties.setGenericSize(10);
        properties.setElectricSize(5);
        Integer id = repository.saveProperties(properties);
        properties = new ParkingLotProperties();
        properties = repository.getPropertiesById(id);
        LOG.debug("fetched: "+ properties.toString());
        assertThat(properties.getGenericSize(), is(10));
        assertThat(properties.getElectricSize(), is(5));
        assertThat(properties.getName(), is("Foo"));
    }

    @Test
    public void testSavePropertiesGetByName() throws Exception {
        properties.setName(ParkingLotJdbcRepository.PARKING_LOT_NAME);
        properties.setGenericSize(1);
        properties.setElectricSize(2);
        properties.setId(repository.saveProperties(properties));
        ParkingLotProperties propertiesByName = repository.getPropertiesByName(ParkingLotJdbcRepository.PARKING_LOT_NAME);
        LOG.debug("fetched: "+ propertiesByName.toString());
        //assertThat(propertiesByName, is(properties)); // TODO implement equals/hashcode
    }

    @Test
    public void testGetAllProperties() throws Exception {
    }

}