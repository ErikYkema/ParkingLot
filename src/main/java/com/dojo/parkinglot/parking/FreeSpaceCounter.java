package com.dojo.parkinglot.parking;

import com.dojo.parkinglot.users.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@Component
public class FreeSpaceCounter {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Map<Class, Integer> freeSpace = new HashMap<>();

    public void setFreeSpace(Class aClass, Integer size) {
        freeSpace.put(aClass, size);
    }

    private boolean hasSpace (Vehicle vehicle) {
        return (freeSpace.get(vehicle.getClass()) > 0);
    }

    public Map<Class, Integer> getFreeSpace() {
        return freeSpace;
    }
    public Integer getFreeSpace(Vehicle vehicle) {
        return freeSpace.get(vehicle.getClass());
    }

    // TODO raise exception and not return boolean?
    public boolean useSpace(Vehicle vehicle) {
        if (hasSpace(vehicle)) {
            freeSpace.put(vehicle.getClass(), freeSpace.get(vehicle.getClass()) - 1);
            return true;
        }
        return false;
    }
}
