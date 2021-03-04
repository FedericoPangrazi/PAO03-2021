/**
 * 
 */
package com.openweather.project.service;
import java.io.*;

import org.json.simple.parser.ParseException;

import com.openweather.project.model.weather_conditions;

/**
 * @author frede
 *
 */
public class filewriter  {
 public static void scrittura(String q, String apiKey) throws ParseException, FileNotFoundException, IOException {
	 weather_conditions dati = parser.current_weather_data(q, apiKey);
	 try {
		 ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("history.txt")));
		 out.writeObject(dati);
		 out.close();
	 } catch (IOException e){ 
		 System.out.println("Errore di I/O");
		System.out.println(e); 
	 }
	 }
 }

