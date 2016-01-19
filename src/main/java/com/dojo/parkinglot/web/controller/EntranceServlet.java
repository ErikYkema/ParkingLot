package com.dojo.parkinglot.web.controller;

import com.dojo.parkinglot.domain.car.GenericCar;
import com.dojo.parkinglot.domain.car.Vehicle;
import com.dojo.parkinglot.parking.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

/**
 * Created by oriezebos on 18-1-2016.
 */
@WebServlet(urlPatterns = "/entrance")
public class EntranceServlet extends HttpServlet{

    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/views/entrance.jsp").forward(
                httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        ParkingLot parkingLot = ParkingLot.getParkingLot();

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
