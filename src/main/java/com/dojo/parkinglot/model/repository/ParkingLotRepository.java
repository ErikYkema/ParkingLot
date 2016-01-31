package com.dojo.parkinglot.model.repository;

import com.dojo.parkinglot.model.ParkingLotProperties;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface ParkingLotRepository {

    public enum Feature {
        DROP_AND_CREATE,
        CREATE_TABLES_IF_NEEDED;
    }

    Integer saveProperties(ParkingLotProperties properties);

    Collection<ParkingLotProperties> getAllProperties();

    ParkingLotProperties getPropertiesById(int id);

    ParkingLotProperties getPropertiesByName(String name);

    void setup(Feature feature);

    void seed();

}
