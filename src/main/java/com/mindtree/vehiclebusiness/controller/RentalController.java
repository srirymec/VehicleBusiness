package com.mindtree.vehiclebusiness.controller;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.vehiclebusiness.dto.BookingDto;
import com.mindtree.vehiclebusiness.dto.LoginDto;
import com.mindtree.vehiclebusiness.dto.Users;
import com.mindtree.vehiclebusiness.dto.ValueObject;
import com.mindtree.vehiclebusiness.dto.ValueObjects;
import com.mindtree.vehiclebusiness.dto.VehicleDto;
import com.mindtree.vehiclebusiness.dto.Vehicles;
import com.mindtree.vehiclebusiness.exception.ServiceException;
import com.mindtree.vehiclebusiness.service.BookingService;
import com.mindtree.vehiclebusiness.service.VehicleService;
import com.mindtree.vehiclebusiness.service.LoginService;

/**
 * @author M1018339
 * 
 */
/**
 * End point controller and setting mapping request from incoming requests
 */

@Controller
@RequestMapping("/vehiclerental/**/")
public class RentalController {

	private static String XML_View = "vehicleXML";

	@Autowired
	private BookingService bookingService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private LoginService loginService;

	/*
	 * Logger is used as custom information for admin. We can check errors in
	 * file in tomcat.
	 */
	private Logger logger = Logger.getLogger(RentalController.class.getName());

	/*
	 * Jaxb2Marshaller is built-in class that converts java object(s) into xml
	 * data using marshalling & vice-vorsa using unmarshalling
	 */

	private Jaxb2Marshaller jaxb2Marshaller;

	public void setJaxb2Marshaller(Jaxb2Marshaller jaxb2Marshaller) {
		this.jaxb2Marshaller = jaxb2Marshaller;
	}

	/*
	 * The request for validate user comes here to validate user name and
	 * password
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/nowvalidate.ren")
	public ModelAndView getUsers() {

		List<LoginDto> lList = new ArrayList<LoginDto>();
		Users users = new Users();
		try {
			lList = loginService.getusers();
			users.setLoginDetails(lList);

			return new ModelAndView(XML_View, "report", users);
		} catch (ServiceException e) {

			logger.error(
					"hey error generated in getting user list please check your code!!!!!",
					e);
			return new ModelAndView(XML_View, "report", users);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/decide.ren")
	public ModelAndView saveUser(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		LoginDto login = (LoginDto) jaxb2Marshaller.unmarshal(source);
		String msg = "";
		try {
			loginService.addUser(login);
			msg = "login";
		} catch (ServiceException e) {
			msg = "addvehicle";
			logger.error("hey error generated in new user code!!!!!", e);
		}
		return new ModelAndView(XML_View, msg, login);
	}

	/*
	 * Saves the vehicle
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/persistvehicle.ren")
	public ModelAndView persistVehicle(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		VehicleDto vehicle = (VehicleDto) jaxb2Marshaller.unmarshal(source);
		ModelAndView model = new ModelAndView();
		String msg = "";
		try {
			vehicleService.addVehicle(vehicle);
			msg = "index";
		} catch (ServiceException e) {
			msg = "addvehicle";
			logger.error(
					"hey error generated in persisting a vehicle, check your code!!!!!",
					e);
		}
		return new ModelAndView(XML_View, msg, vehicle);
	}

	/*
	 * Saves the Booking
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/persistbooking.ren")
	public ModelAndView persistBooking(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		BookingDto booking = new BookingDto();
		booking = (BookingDto) jaxb2Marshaller.unmarshal(source);
		String viewName = "";
		try {
			bookingService.bookVehicle(booking);
			viewName = "index";
		} catch (ServiceException e) {
			viewName = "booking";
			logger.error(
					"hey error generated in persisting a booking, check your code!!!!!",
					e);
		}

		return new ModelAndView(XML_View, viewName, booking);
	}

	/*
	 * Get populateVehicle list and send back to the requested client
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/populateVehicles.ren")
	public ModelAndView populateVehicles(@RequestBody String body) {
		List<String> vehics;
		Source source = new StreamSource(new StringReader(body));

		BookingDto booking = (BookingDto) jaxb2Marshaller.unmarshal(source);
		Vehicles vehicles = new Vehicles();
		try {
			vehics = vehicleService.populateVehicles(booking.getCategory());
			vehicles.setVehicleList(vehics);

		} catch (ServiceException e) {
			logger.error(
					"hey error generated in fetching vehicle, check your code!!!!!",
					e);
		}

		return new ModelAndView(XML_View, "Success", vehicles);
	}

	/*
	 * Booking request comes here and report will be sent to requested client
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/bookingreport.ren")
	public ModelAndView getBookingReport() {
		List<ValueObject> report = new ArrayList<ValueObject>();
		ValueObjects objects = new ValueObjects();
		try {
			report = bookingService.getReport();
			objects.setList(report);

		} catch (ServiceException e) {

			logger.error(
					"hey error generated in getting report, check your code!!!!!",
					e);
		}
		return new ModelAndView(XML_View, "report", objects);

	}

	@RequestMapping(method = RequestMethod.POST, value = "noRent.ren")
	public ModelAndView noRent(@RequestBody String body) {

		Source source = new StreamSource(new StringReader(body));
		BookingDto booking = (BookingDto) jaxb2Marshaller.unmarshal(source);

		return new ModelAndView(XML_View, "success", booking);
	}

	/*
	 * Get total rent request comes here and total rent will be sent after
	 * calculating total rent
	 */

	@RequestMapping(method = RequestMethod.POST, value = "getTotalRent.ren")
	public ModelAndView getTotalRent(@RequestBody String body) {

		Source source = new StreamSource(new StringReader(body));
		BookingDto booking = (BookingDto) jaxb2Marshaller.unmarshal(source);
		Date from = booking.getBookedFrom();
		Date to = booking.getBookedTo();
		int days = (int) (to.getTime() - from.getTime())
				/ (1000 * 60 * 60 * 24);
		int daily;
		try {
			daily = vehicleService
					.getDailyRent(booking.getVehicle().getRegNo());
			if (days > 0) {
				booking.setTotalRent(daily * (days + 1));
			} else {
				booking.setTotalRent(daily);
			}
			List<String> vehics = vehicleService.populateVehicles(booking
					.getCategory());
		} catch (ServiceException e) {

			logger.error(
					"hey error generated in fetching total rent, check your code!!!!!",
					e);
		}
		return new ModelAndView(XML_View, "success", booking);
	}

}
