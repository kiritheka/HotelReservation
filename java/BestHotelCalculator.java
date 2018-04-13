package try5;

import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import try5.Hotel;

public class BestHotelCalculator {

	HotelDetails hotelDetail = new HotelDetails();

	public List<Entry<Hotel, Integer>> getSortedPriceList(HashMap<Hotel, Integer> totalPrice) {

		List<Entry<Hotel, Integer>> list = new LinkedList<Map.Entry<Hotel, Integer>>(totalPrice.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Hotel, Integer>>() {
			public int compare(Map.Entry<Hotel, Integer> o1, Map.Entry<Hotel, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		List<Entry<Hotel, Integer>> bestHotellist = new LinkedList<Map.Entry<Hotel, Integer>>();
		int count = 0;
		int val = list.get(list.size() - 1).getValue();
		for (Entry<Hotel, Integer> entry : list) {
			if (entry.getValue().equals(val)) {
				bestHotellist.add(entry);
				count++;
			}
		}

		if (count == 1) {
			return bestHotellist;
		} else if (count > 1) {
			HashMap<Hotel, Integer> hotelRating = new HashMap<Hotel, Integer>();
			for (Entry<Hotel, Integer> entry : bestHotellist) {
				hotelRating.put(entry.getKey(), entry.getKey().starRating);
			}
			List<Entry<Hotel, Integer>> topRateHotel = new LinkedList<Entry<Hotel, Integer>>(hotelRating.entrySet());
			Collections.sort(topRateHotel, new Comparator<Map.Entry<Hotel, Integer>>() {
				public int compare(Map.Entry<Hotel, Integer> o1, Map.Entry<Hotel, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			return topRateHotel;
		}
		return bestHotellist;
	}
}
