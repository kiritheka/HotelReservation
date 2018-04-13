package try5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import try5.HotelDetails.Customer;

public class Booking {

	public static void main(String args[]) {

		HotelDetails hotelDetails = new HotelDetails();
		BestHotelCalculator bestHotelCalculator = new BestHotelCalculator();
		HashMap<Hotel, Integer> totalPrice = new HashMap<Hotel, Integer>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Are you a Regular or Reward Customer?");
		Customer customerType = Customer.valueOf(scan.nextLine());

		System.out.println("Dates on which your willing stay");
		String groupOfdate = scan.nextLine();
		String[] dateArray = groupOfdate.split(",");
		System.out.println(Arrays.toString(dateArray));

		List<Hotel> hotelList = hotelDetails.getAllHotelDetails();
		for (Hotel hotel : hotelList) {
			int price = hotelDetails.getTotalCost(hotel, customerType, dateArray);
			System.out.println(hotel.hotelName + "=" + price);
			totalPrice.put(hotel, price);
		}

		List<Entry<Hotel, Integer>> besttHotel = bestHotelCalculator.getSortedPriceList(totalPrice);
		System.out.println("Best Hotel for you is  " + besttHotel.get(0).getKey().hotelName);

	}
}
