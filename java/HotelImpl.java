package try1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HotelImpl implements Hotel {

	enum Customer {
		Regular, Reward
	}

	public List<String> getHotels() {
		List<String> hotelNames = new ArrayList<String>();
		hotelNames.add("Lakewood");
		hotelNames.add("Bridgewood");
		hotelNames.add("Ridgewood");

		return hotelNames;

	}

	@Override
	public int getHotelRating(String hotelName) {
		HashMap<String, Integer> hotelList = new HashMap<String, Integer>();
		hotelList.put("Lakewood", 3);
		hotelList.put("Bridgewood", 4);
		hotelList.put("Ridgewood", 5);
		int hotelRating = hotelList.get(hotelName);

		return hotelRating;
	}

	@Override
	public int getWeekDayPrice(String hotelName, Customer customerType) {
		HashMap<String, Integer> weekDayPrice = new HashMap<String, Integer>();
		int hotelPrice = 0;

		if (Customer.Regular.equals(customerType)) {
			weekDayPrice.put("Lakewood", 110);
			weekDayPrice.put("Bridgewood", 160);
			weekDayPrice.put("Ridgewood", 220);
			hotelPrice = weekDayPrice.get(hotelName);
			return hotelPrice;
		} else if (Customer.Reward.equals(customerType)) {
			weekDayPrice.put("Lakewood", 80);
			weekDayPrice.put("Bridgewood", 110);
			weekDayPrice.put("Ridgewood", 100);
			hotelPrice = weekDayPrice.get(hotelName);
			return hotelPrice;
		}
		return hotelPrice;
	}

	@Override
	public int getWeekEndPrice(String hotelName, Customer customerType) {
		HashMap<String, Integer> weekEndPrice = new HashMap<String, Integer>();
		int hotelPrice = 0;

		if (Customer.Regular.equals(customerType)) {
			weekEndPrice.put("Lakewood", 90);
			weekEndPrice.put("Bridgewood", 60);
			weekEndPrice.put("Ridgewood", 150);
			hotelPrice = weekEndPrice.get(hotelName);

		} else if (Customer.Reward.equals(customerType)) {
			weekEndPrice.put("Lakewood", 80);
			weekEndPrice.put("Bridgewood", 50);
			weekEndPrice.put("Ridgewood", 40);
			hotelPrice = weekEndPrice.get(hotelName);
		}
		return hotelPrice;
	}

	@Override
	public int getTotalCost(String hotelName, Customer customerType, Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_WEEK);
		int hotelPrice;

		if ((day >= Calendar.MONDAY) && (day <= Calendar.FRIDAY)) {
			hotelPrice = getWeekDayPrice(hotelName, customerType);
		} else {
			hotelPrice = getWeekEndPrice(hotelName, customerType);
		}
		return hotelPrice;
	}
}
