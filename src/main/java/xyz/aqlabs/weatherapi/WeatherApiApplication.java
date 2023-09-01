package xyz.aqlabs.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.aqlabs.weatherapi.service.CoordinatesService;

@SpringBootApplication
public class WeatherApiApplication {


	public static void main(String[] args) {

		SpringApplication.run(WeatherApiApplication.class, args);

		//TEST COORDINATE FUNCTIONALITY
		//CoordinatesService service = new CoordinatesService();
		//System.out.println(service.getCoordinates("93536"));
	}

}
