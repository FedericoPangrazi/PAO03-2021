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
import org.springframework.web.bind.annotation.PostMapping;
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
	/**
	 * rotta per le previsioni future
	 * @param q
	 * @return
	 * @throws ParseException
	 */

	@GetMapping("/predictions")
	public ResponseEntity<Object> predictions(@RequestParam String q) throws ParseException {

		return new ResponseEntity<>(parser.forecast_Stamper(q), HttpStatus.OK);
	}

/**
 * rotta per visualizzare le condizioni meteo correnti
 * @param q
 * @return
 * @throws ParseException
 */

	@GetMapping("/current")
	public ResponseEntity<Object> current_situation(@RequestParam String q) throws ParseException {
		return new ResponseEntity<>(parser.current_Stamper(q), HttpStatus.OK);

	}

	/**
	 * rotta per salvare le condizioni attuali in uno storico
	 * @param q
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	@GetMapping("/save_history")
	public ResponseEntity<Object> saved(@RequestParam String q)
			throws FileNotFoundException, ParseException, IOException {

		return new ResponseEntity<>(filewriter.scrittura(q), HttpStatus.OK);

	}
	/**
	 * rotta per salvare i dati utili a generare statistiche in un file json
	 * @param q
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	@GetMapping("/stats")
	public ResponseEntity<Object> stats_saved(@RequestParam String q)
			throws FileNotFoundException, ParseException, IOException {
	return new ResponseEntity<>(filewriter.scritturaStats(q), HttpStatus.OK);
	
	
	/**
	 * rotta di prova per testare il funzionamento del reader
	 */
}
	@GetMapping("/see_stats")
	public ResponseEntity<Object> see_stats(@RequestParam String q) throws java.text.ParseException, ParseException, IOException{
		return new ResponseEntity<>(filereader.stats_filler(q), HttpStatus.OK);
	}
	/**
	 * rotta per generare statistiche
	 * @param q
	 * @param period
	 * @return
	 * @throws java.text.ParseException
	 * @throws ParseException
	 * @throws IOException
	 */
	@PostMapping("/calculate")
	public ResponseEntity<Object> calculate(@RequestParam String q,@RequestParam (name= "period", defaultValue="0") int period) throws java.text.ParseException, ParseException, IOException{
		return new ResponseEntity<>(calculator.S_calculator(q,period), HttpStatus.OK);
	}
	
	
}