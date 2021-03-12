/**
 * 
 */
package com.openweather.project.service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;

import com.openweather.project.model.weather_conditions;

/**
 * @author frede
 *
 */

public class filewriter  {
	/*
	 * questo metodo va a scrivere un file con i dati current raccolti ad ogni chiamata e restituisce il path del file in 
	 * formato stringa
	 */
	
 public static String scrittura(String q) throws  IOException, ParseException {
	 String dati = parser.current_Stamper(q);
	 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	 String today = date.format(new Date());
	 String filename = q +" "+today;
	 String path = System.getProperty("user.dir")+filename+".txt";
	 try {
		 PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(path)));
		 output.println(dati);
		 output.close();
		 
	 } catch (IOException e){ 
		 System.out.println("Errore di I/O");///		System.out.println(e); 
	 }
	 return path;
	 }
}

