package try5;

public class Hotel {

	String hotelName;
	int starRating;
	int regularWeekDayPrice;
	int rewardWeekDayPrice;
	int regularWeekEndPrice;
	int rewardWeekEndPrice;

	public Hotel(String hotelName, int starRating, int regularWeekDayPrice, int rewardWeekDayPrice,
			int regularWeekEndPrice, int rewardWeekEndPrice) {
		this.hotelName = hotelName;
		this.starRating = starRating;
		this.regularWeekDayPrice = regularWeekDayPrice;
		this.rewardWeekDayPrice = rewardWeekDayPrice;
		this.regularWeekEndPrice = regularWeekEndPrice;
		this.rewardWeekEndPrice = rewardWeekEndPrice;
	}

	public int getStarRating() {
		return starRating;
	}

	public int getRegularWeekEndPrice() {
		return regularWeekEndPrice;
	}

	public int getRegularWeekDayPrice() {
		return regularWeekDayPrice;
	}

	public int getRewardWeekEndPrice() {
		return rewardWeekEndPrice;
	}

	public int getRewardWeekDayPrice() {
		return rewardWeekDayPrice;
	}

}
