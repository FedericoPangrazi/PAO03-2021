/**
 * 
 */
package com.openweather.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openweather.project.model.weather_conditions;
import com.openweather.project.service.filewriter;
import com.openweather.project.service.*;

/**
 * @author frede
 *
 */
@RestController
public class Controller {
	/*
	 * rotta per le previsioni future
	 */
	@GetMapping("/predictions")
	public ArrayList<weather_conditions> predictions (@RequestParam(name = "q") String q, @RequestParam(name = "apiKey") String apiKey ) throws ParseException{
	return parser.forecast_weather_data(q, apiKey);
	}
	/*
	 * rotta per le condizioni attuali
	 */
	
	@GetMapping("/current")
	public weather_conditions current(@RequestParam(name = "q") String q, @RequestParam(name = "apiKey") String apiKey) throws ParseException {
		return parser.current_weather_data(q, apiKey);
	}
	/*
	 * rotta per salvare le condizioni attuali nello storico
	 */
	@GetMapping("/save_history")
	public void saved(@RequestParam(name = "q") String q, @RequestParam(name = "apiKey") String apiKey) throws FileNotFoundException, ParseException, IOException {
		filewriter.scrittura(q, apiKey);
	}
	
}
