package com.gubsky.weatherapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherappApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("API_TOKEN", dotenv.get("API_TOKEN"));
		SpringApplication.run(WeatherappApplication.class, args);
	}
}
