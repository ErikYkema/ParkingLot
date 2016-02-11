package com.dojo.parkinglot.web.controller;

import com.dojo.parkinglot.domain.car.GenericCar;
import com.dojo.parkinglot.domain.car.Vehicle;
import com.dojo.parkinglot.model.repository.ParkingLotRepository;
import com.dojo.parkinglot.parking.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

@Component
//@WebServlet(urlPatterns = "/entrance") // not compatible with Spring autowiring
@Path("entrance")
public class EntranceServlet extends HttpServlet{

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/views/entrance.jsp").forward(
                httpServletRequest, httpServletResponse);
    }

//    @Autowired // doesn't work$@$#!
//    ParkingLotRepository parkingLotRepository;

    @Autowired // doesn't work$@$#!
    ParkingLot parkingLot;

    // if default constructor missing, errors out on <init> missing...
    public EntranceServlet() {
        LOG.debug("constructor...");
        // TODO grab beans from applicationContext... as injection doesn't work... or make it somehow a singleton
    }

    @Autowired
    public EntranceServlet(ParkingLotRepository parkingLotRepository, ParkingLot parkingLot) {
        LOG.debug("constructor with arguments...");
        this.parkingLot = parkingLot;
//        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


        String license = httpServletRequest.getParameter("license");
        boolean result;

        // TODO fix session/server scope
        Vehicle vehicle = new GenericCar(license);
        result = parkingLot.requestParkingSpace(vehicle);
        LOG.info(String.format("current freespace: %s", parkingLot.getFreeSpaceCounter().getFreeSpace(vehicle)));
        LOG.info("parkingLot.requestParkingSpace" + (result ? "true" : "false"));
        // TODO implement lookup of card/license to car-type
        //Vehicle vehicle = vehicleService.findProductByLicense(license);
        if (result) {
            httpServletRequest.setAttribute("message", String.format("Hartelijk welkom %s, u kunt doorrijden!", license));
        } else {
            httpServletRequest.setAttribute("message", String.format("Helaas %s, u kunt niet doorrijden!", license));
        }
        ;

        // Redirect naar de feedback pagina.
        httpServletRequest.getRequestDispatcher("WEB-INF/views/feedback.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
