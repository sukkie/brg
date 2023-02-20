package com.example.demo.its;

import org.apache.http.HttpException;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class BrgAutoSearch implements Runnable {

	private static final String DOMAIN = "https://as.its-kenpo.or.jp";

	private static final String MAIN_URL = DOMAIN + "/apply/empty_new?s=%s";
	
//	private static final String EMAIL = "guswls6212@gmail.com";
//	private static final String EMAIL = "prentice7725@gmail.com";
//	private static final String EMAIL = "slygshc@gmail.com";
	private static final String EMAIL = "sukkie512@yahoo.co.jp";

	private static final String[] NUMBER_PEOPLE = {"3"};

	private static final String NUMBER_ROOM = "1";

	private static final String NUMBER_STAY = "1";

	private static final ZoneId zoneId = ZoneId.of("Asia/Tokyo");

	private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public BrgAutoSearch() {
	}
	/**
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws HttpException
	 */
	@Override
	public void run() {

		System.out.println("START");

		HotelPlanner hotelPlanner = new HotelPlanner("https://www.hotelplanner.com/Common/Cfcs/services/rates/checkRates.htm?locale=en_US&currency=IDR&brandCode=WE&starRating=5.0&vendor=ama&hotelId=F7535&aky=9BE75F5621495FA57294307EB1B29EA5&_dc=1676896327875&gid=0&checkin=07%2F27%2F2023&checkout=07%2F31%2F2023&numRooms=1&numAdults=2&numChildren=0&indate=07%2F27%2F2023&outdate=07%2F31%2F2023&page=1&start=0&limit=25&sort=%5B%7B%22property%22%3A%22AVERAGERATE%22%2C%22direction%22%3A%22ASC%22%7D%5D");
		hotelPlanner.init();


		try {
			Thread.sleep(3 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (true) {
			hotelPlanner.run();

			try {
				Thread.sleep(3 * 60 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
