/**
 * 
 */
package com.openweather.project.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import com.openweather.project.model.stats;

/**
 * @author frede
 *
 */
public class filereader {
   
	/**
	 * metodo per leggere dal file dello storico statistiche i dati ed inserirli in un jsonarray
	 * @param q la città richiesta
	 * @return fromfile
	 * @throws ParseException exception
	 * @throws IOException exception
	 */
	@SuppressWarnings( { "null", "unchecked" } )
	public static JSONArray statistiche(String q) throws ParseException, IOException {
    String path = System.getProperty("user.dir")+q+"_stats.json";
    JSONParser parser = new JSONParser();
    JSONArray fromfile = new JSONArray();
    BufferedReader lettore= new BufferedReader(new FileReader(path));
    
    while(lettore!=null) {
    	String line = lettore.readLine();
    	JSONObject object=(JSONObject)parser.parse(line);
    	 fromfile.add(object);
    	 System.out.println("oggetto aggiunto"); 
    	 
    }
    	lettore.close();
    return fromfile;
   }
   
   /**
    * metodo per settare i dati presenti nel jsonarray precedentemente riempito in un oggetto stats
    * @param q la città richiesta
    * @return summary
    * @throws java.text.ParseException exception
    * @throws ParseException exception
    * @throws IOException exception
    */
   public static stats stats_filler(String q) throws java.text.ParseException, ParseException, IOException {
	   JSONArray file=statistiche(q);//errore
	   stats summary = new stats();
	   for (Object o:file) {
		   JSONObject pointer =(JSONObject)o;
		   String date=(String) pointer.get("date");
		   SimpleDateFormat datesimple = new SimpleDateFormat("yyyy-MM-dd");
		   datesimple.parse(date);
		   summary.setdate(datesimple);
		   Object temp= pointer.get("temp");
		   summary.setTemp((double)temp);
		   Object pressure=pointer.get("pressure");
		   summary.setPressure((double)pressure);
		   Object clouds=pointer.get("clouds");
		   summary.setClouds((double)clouds);
		   int contatore=summary.getCounter();
		   contatore++;
		   summary.setCounter(contatore);
	   }
	   return summary;
   }
}

