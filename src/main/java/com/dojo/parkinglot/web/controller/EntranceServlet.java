package com.dojo.parkinglot.web.controller;

import com.dojo.parkinglot.domain.car.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oriezebos on 18-1-2016.
 */
@WebServlet(urlPatterns = "/entrance")
public class EntranceServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/views/entrance.jsp").forward(
                httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String licence = httpServletRequest.getParameter("licence");
        //todo
        //Vehicle vehicle = vehicleService.findProductByLicence(licence);
        // kijk of er een parkingspace vrij gegeven kan worden voor dit vehicle
        httpServletRequest.setAttribute("message", String.format("Hartelijk welkom %s, u kunt doorrijden!", licence));

        // Redirect naar de feedback pagina.
        httpServletRequest.getRequestDispatcher("WEB-INF/views/result.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
