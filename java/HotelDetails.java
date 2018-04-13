package try5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import try5.Hotel;
import try5.HotelDetails.Customer;

public class HotelDetails {

	enum Customer {
		Regular, Reward
	}

	Hotel lakeWood = new Hotel("LakeWood", 3, 110, 80, 90, 80);
	Hotel bridgewood = new Hotel("Bridgewood", 4, 160, 110, 60, 50);
	Hotel ridgewood = new Hotel("Ridgewood", 5, 220, 100, 150, 40);

	public List<Hotel> getAllHotelDetails() {
		List<Hotel> hotelDetails = new ArrayList<Hotel>();
		hotelDetails.add(lakeWood);
		hotelDetails.add(bridgewood);
		hotelDetails.add(ridgewood);
		return hotelDetails;
	}

	public int getTotalCost(Hotel hotel, Customer customerType, String[] dateArray) {

		int priceTotal = 0, hotelPrice = 0;
		for (String singleDate : dateArray) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
			try {
				date = dateFormat.parse(singleDate);
			} catch (ParseException e) {
				System.out.println("Invalid date format");
			}

			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int day = c.get(Calendar.DAY_OF_WEEK);

			if (customerType.Regular.equals(customerType)) {
				if ((day >= Calendar.MONDAY) && (day <= Calendar.FRIDAY)) {
					hotelPrice = hotel.getRegularWeekDayPrice();
				} else {
					hotelPrice = hotel.getRegularWeekEndPrice();
				}
			} else if (customerType.Reward.equals(customerType)) {
				if ((day >= Calendar.MONDAY) && (day <= Calendar.FRIDAY)) {
					hotelPrice = hotel.getRewardWeekDayPrice();
				} else {
					hotelPrice = hotel.getRewardWeekEndPrice();
				}
			}
			priceTotal = priceTotal + hotelPrice;
		}
		return priceTotal;
	}

}
