package com.dojo.parkinglot.endpoint.v1.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.invoke.MethodHandles;

@Controller
@RequestMapping("/parkinglot")
public class ParkingLotResource {

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @RequestMapping(value="/exit/{license}", method=RequestMethod.GET)
    public boolean exit (@RequestParam String license) {
        LOG.debug("Exit [POST] method called...");
        return true;
    }

}