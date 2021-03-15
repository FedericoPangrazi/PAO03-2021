/**
 * 
 */
package com.openweather.project.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.openweather.project.model.stats;

/**
 * @author frede
 *
 */
public class filereader {
   public static JSONArray statistiche(String q) throws ParseException {
    String path = System.getProperty("user.dir")+q+"_stats.json";
    JSONParser parser = new JSONParser();
    JSONArray fromfile = new JSONArray();
    try{
    	BufferedReader lettore= new BufferedReader(new FileReader(path));
    	String line = lettore.readLine();
    	fromfile=(JSONArray)parser.parse(line);
    lettore.close();
	}catch (IOException e){ 
		 System.out.println("Errore di I/O");///
   
    }
    return fromfile;
   }
   
   
   public static stats stats_filler(String q) throws java.text.ParseException, ParseException {
	   JSONArray file=statistiche(q);
	   stats summary = new stats();
	   for (Object o:file) {
		   JSONObject pointer =(JSONObject)o;
		   String date=(String) pointer.get("date");
		   SimpleDateFormat datesimple = new SimpleDateFormat("yyyy-MM-dd");
		   datesimple.parse(date);
		   summary.setdate(datesimple);
		   Double temp=pointer.getDouble("temp");
		   summary.setTemp(temp);
		   Double pressure=pointer.getDouble("pressure");
		   summary.setPressure(pressure);
		   Double clouds=pointer.getDouble("clouds");
		   summary.setClouds(clouds);
		   int contatore=summary.getCounter();
		   contatore++;
		   summary.setCounter(contatore);
	   }
	   return summary;
   }
}

