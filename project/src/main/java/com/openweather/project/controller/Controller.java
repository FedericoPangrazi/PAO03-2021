/**
 * 
 */
package com.openweather.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Object> predictions(@RequestParam String q) throws ParseException {

		return new ResponseEntity<>(parser.forecast_Stamper(q), HttpStatus.OK);
	}
	/*
	 * rotta per le condizioni attuali
	 */

	@GetMapping("/current")
	public ResponseEntity<Object> current_situation(@RequestParam String q) throws ParseException {
		//System.out.println(parser.current_Stamper(q));
		return new ResponseEntity<>(parser.current_Stamper(q), HttpStatus.OK);

	}

	/*
	 * rotta per salvare le condizioni attuali nello storico
	 */
	@GetMapping("/save_history")
	public ResponseEntity<Object> saved(@RequestParam String q)
			throws FileNotFoundException, ParseException, IOException {

		return new ResponseEntity<>(filewriter.scrittura(q), HttpStatus.OK);

	}

}
