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

import org.json.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author frede
 *
 */

public class filewriter  {
	/**
	 * questo metodo va a scrivere un file con i dati current raccolti ad ogni chiamata e restituisce il path del file in 
	 * formato stringa
	 * @param q la città richiesta
	 * @return il path
	 * @throws IOException exception
	 * @throws ParseException exception
	 */
	
 public static String scrittura(String q) throws  IOException, ParseException {
	 String dati = parser.current_Stamper(q);
	 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	 String today = date.format(new Date());
	 String filename = q ;
	 String path = System.getProperty("user.dir")+filename+".txt";
	 try {
		 PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(path,true)));//non sovrascrive, scrive di seguito
		 output.println(today);
		 output.println(dati);
		 output.close();
	 } catch (IOException e){ 
		 System.out.println("Errore di I/O");///		System.out.println(e); 
	 }
	 return path;
	 }
 
 /**
  * metodo per salvare i dati utili a generare statistiche in un file .json composto da JSONObject
  * @param q la città richiesta
  * @return path 
  * @throws IOException exception
  * @throws ParseException exception
  */
 
 public static String scritturaStats(String q) throws IOException, ParseException {
	 JSONObject statistiche = parser.current_stat_generator(q);
	 String filename = q ;
	 String path = System.getProperty("user.dir")+filename+"_stats.json";
	 try {
		 PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(path,true)));//non sovrascrive, scrive di seguito
		 output.println(statistiche);
		 output.close();
	 } catch (IOException e){ 
		 System.out.println("Errore di I/O");///		System.out.println(e); 
	 }
	 return path;
	 }
 }

 

