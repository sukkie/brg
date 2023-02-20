package com.example.demo;

import com.example.demo.its.BrgAutoSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoApplication {

	public static Map<String, String> RESULT_SET = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try {
			Thread t1 =new Thread(new BrgAutoSearch());   // Using the constructor Thread(Runnable r)
			t1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
