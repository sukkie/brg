package com.example.demo;

import com.example.demo.brg.HotelManager;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static Map<String, String> RESULT_SET = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		HotelManager hotelManager = new HotelManager();
		hotelManager.init();
		hotelManager.run();
	}

}
