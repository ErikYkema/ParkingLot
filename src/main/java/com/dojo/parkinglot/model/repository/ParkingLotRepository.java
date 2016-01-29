package com.dojo.parkinglot.model.repository;

import com.dojo.parkinglot.model.ParkingLotProperties;

import java.util.Collection;

public interface ParkingLotRepository {
    Integer saveProperties(ParkingLotProperties properties);

    Collection<ParkingLotProperties> getAllProperties();

    ParkingLotProperties getPropertiesById(int id);
}
