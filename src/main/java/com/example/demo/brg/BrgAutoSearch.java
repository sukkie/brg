package com.example.demo.brg;

import com.example.demo.brg.hotel.AbstractHotel;
import java.util.List;

public class BrgAutoSearch implements Runnable {

	private List<AbstractHotel> hotelList;

	public BrgAutoSearch(List<AbstractHotel> hotelList) {
		this.hotelList = hotelList;
	}

	@Override
	public void run() {

		System.out.println("START");

		while (true) {
			for (AbstractHotel hotelInterface : hotelList) {
				hotelInterface.run();
				try {
					Thread.sleep(3 * 60 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
