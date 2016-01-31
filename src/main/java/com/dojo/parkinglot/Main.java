package com.dojo.parkinglot;

import com.dojo.parkinglot.domain.car.Vehicle;
import com.dojo.parkinglot.model.repository.ParkingLotRepository;
import com.dojo.parkinglot.parking.ParkingLot;
import com.dojo.parkinglot.parking.ParkingSpaceUsage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Map;

@Component
public class Main {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) throws IOException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ParkingLotRepository repository = (ParkingLotRepository) context.getBean("parkingLotRepository");
        repository.setup(ParkingLotRepository.Feature.DROP_AND_CREATE);
        repository.seed();

        ParkingLot parkingLot = (ParkingLot) context.getBean("parkingLot");
        parkingLot.init();
        LOG.info(String.format("generic size: %s", parkingLot.getProperties().getGenericSize()));

        Map<Vehicle, ParkingSpaceUsage> parkingSpaceUsageList = parkingLot.getParkingSpaceUsages();
        LOG.info(String.format("parkingSpaceUsageList.size(): %s", parkingSpaceUsageList.size()));
    }
}
