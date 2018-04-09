package try1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import try1.HotelImpl.Customer;

public class BookingHotel {
	
	public  Map<String, Integer> getSortedPriceList(HashMap<String, Integer> totalPrice){
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(totalPrice.entrySet());
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		Collections.reverse(list);

		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("After sorting " + sortedMap);
		//[17-11-1995, 13-12-1995, 12-09-1998]
		return sortedMap;
	}


	public static void main(String args[]) throws ParseException {

		HotelImpl hotelListImpl = new HotelImpl();
		BookingHotel bookingHotel = new BookingHotel();

		Scanner scan = new Scanner(System.in);
		System.out.println("Are you a Regular or Reward Customer?");
		Customer customerType = Customer.valueOf(scan.nextLine());
		System.out.println("Dates on which your willing stay");
		String groupOfdate = scan.nextLine();
		String[] dateArray = groupOfdate.split(",");
		System.out.println(Arrays.toString(dateArray));

		HashMap<String, Integer> totalPrice = new HashMap<String, Integer>();
		for (String hotelName : hotelListImpl.getHotels()) {
			int price;
			int priceOld = 0;
			for (String singleDate : dateArray) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date date = dateFormat.parse(singleDate);
				price = hotelListImpl.getTotalCost(hotelName, customerType, date);
				priceOld = priceOld + price;
			}
			totalPrice.put(hotelName, priceOld);
		}
		
		Map<String, Integer> sortedMap=bookingHotel.getSortedPriceList(totalPrice);
		System.out.println(sortedMap);
		
	}
}
