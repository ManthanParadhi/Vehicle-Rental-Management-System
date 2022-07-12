package com.shashank.vrms.controllers.customer;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.shashank.vrms.daos.BookingDAO;
import com.shashank.vrms.daos.UserDAO;
import com.shashank.vrms.daos.VehicleDAO;
import com.shashank.vrms.enums.BookingStatus;
import com.shashank.vrms.models.Booking;
import com.shashank.vrms.models.User;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.utilities.Helper;

@WebServlet("/c/book/*")
public class AddBookingController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getPathInfo();
		int id = Integer.parseInt(path.substring(1));

		try {

			VehicleDAO vehicleDAO = new VehicleDAO();
			Vehicle vehicle = vehicleDAO.getVehicleById(id);

			

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/customer/addBooking.jsp");
			request.setAttribute("vehicle", vehicle);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession(false);
			session.setAttribute("msg", "Something Went wrong, Please try again...");
			response.sendRedirect(request.getContextPath() + "/vehicles");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("this doPost from AddBooking controller");
		System.out.println(request.getParameter("fromDate").replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2")+ LocalTime.now()+" this is from date");
		System.out.println(request.getParameter("tillDate").replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2")+"this is till date");
		int id = Integer.parseInt(request.getParameter("id"));
		Timestamp fromDate = Timestamp.valueOf(request.getParameter("fromDate").replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") +" "+ LocalTime.now());
		
		Timestamp tillDate = Timestamp.valueOf(request.getParameter("tillDate").replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") +" "+ LocalTime.now());

		Boolean needDriver = false;
		
		
		if(! Arrays.toString(request.getParameterValues("needDriver")).equals("null")) {
			needDriver = true;
		}
		
		System.out.println(needDriver);
		long numberOfDays = Duration.between(fromDate.toLocalDateTime(), tillDate.toLocalDateTime()).toDays();

		System.out.println(numberOfDays);

		VehicleDAO vehicleDAO = new VehicleDAO();
		Vehicle vehicle = vehicleDAO.getVehicleById(id);

		HttpSession session = request.getSession(false);

		if (!Helper.checkIfBookingDatesValid(fromDate, tillDate, vehicle)) {

			session.setAttribute("msg", "Booking is not available on this dates...");
			response.sendRedirect(request.getContextPath() + "/c/book/" + id);

			return;
		}

		try {

			BookingDAO bookingDAO = new BookingDAO();

			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByEmailId((String) session.getAttribute("email"));
			Booking booking = new Booking();

			double bookingPrice = numberOfDays * vehicle.getPricePerDay();

			if (needDriver) {

				bookingPrice = bookingPrice + 1000;
			}

			booking.setBookedOn(new Timestamp(System.currentTimeMillis()));
			booking.setFromDate(fromDate);
			booking.setTillDate(tillDate);
			booking.setBookingPrice(bookingPrice);
			booking.setNeedDriver(needDriver);
			booking.setUser(user);
			booking.setBookingStatus(BookingStatus.PENDING);
			booking.setVehicle(vehicle);

			bookingDAO.addBooking(booking);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "Something Went wrong, Please try again...");
			response.sendRedirect(request.getContextPath() + "/vehicles");
		}

	}

}
