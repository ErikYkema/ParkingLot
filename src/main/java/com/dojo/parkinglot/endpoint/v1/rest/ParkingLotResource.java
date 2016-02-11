package com.dojo.parkinglot.endpoint.v1.rest;

import com.dojo.parkinglot.parking.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.invoke.MethodHandles;

//@Controller
//@RequestMapping("/parkinglot")
@Component
@Path("/hello") // this makes the web.xml resourceconfig error disappear
public class ParkingLotResource {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//    @RequestMapping(value="/exit/{license}", method=RequestMethod.GET)
    public boolean exit (@RequestParam String license) {
        LOG.debug("Exit [POST] method called...");
        return true;
    }

    @Autowired
    ParkingLot parkingLot;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello () {
        LOG.debug("Hello [GET] method called...");
        return "hello " + (parkingLot == null ? "null" : "not null");
    }


}