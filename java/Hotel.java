package try1;

import java.util.Calendar;
import java.util.Date;

import try1.HotelImpl.Customer;

public interface Hotel {

	public int getHotelRating(String hotelName) ;
	public int getWeekDayPrice(String hotelName, Customer customerType);
	public int getWeekEndPrice(String hotelName, Customer customerType) ;
	public int getTotalCost(String hotelName, Customer customerType, Date date);

}
