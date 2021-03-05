/**
 * 
 */
package com.openweather.project.service;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

import com.openweather.project.model.weather_conditions;



/*
 * questa classe serve ad ottenere i dati dal server riguardo le previsioni e le condizioni attuali e ad integrarli in 
 * strutture dati create appositamente
 */




public class parser {
	
	
	private String apiKey="0b1a0a7aebf19e0cbbe68d82742bdf97";
/*
 * questo metodo ottiene i dati delle previsioni per i prossimi 5 giorni dalla chiamata API e li restituisce come un 
 * JSONObject
 */
	
	
	public JSONObject  forecast_weather_data (String q) throws ParseException {
		JSONObject response;
		String url = "api.openweathermap.org/data/2.5/forecast?q=" + q +"&appid=" + apiKey;
		RestTemplate appoggio = new RestTemplate();
		response = new JSONObject(appoggio.getForObject(url, String.class));
		return response;
	}
	/*
	 * questo metodo ottiene i dati delle condizioni meteo attuali dalla chiamata API e li restituisce come un 
     * JSONObject
	 */
	
	public JSONObject current_weather_data(String q) throws ParseException{
		JSONObject response;
		String url = "api.openweathermap.org/data/2.5/weather?q="+ q +"&appid=" + apiKey;
		RestTemplate appoggio = new RestTemplate();
		response = new JSONObject(appoggio.getForObject(url, String.class));
		return response;
	}
	
	/*
	 * questo metodo riempie un ArrayList di weather_conditions con i dati delle previsioni precedentemente ottenuti
	 */
	
	public ArrayList<weather_conditions> forecast_fill (String q) throws ParseException{
		ArrayList<weather_conditions> results = new ArrayList<weather_conditions>();
		JSONObject data = forecast_weather_data(q);
		JSONArray list = (JSONArray)data.get("list");
		for (Object currents : list) {
			JSONObject situation = (JSONObject) currents;
			JSONObject main = (JSONObject)situation.get("main");
			JSONArray weather = (JSONArray)situation.get("weather");
			JSONObject effective_weather = (JSONObject)weather.get(0);
			JSONObject clouds=(JSONObject)situation.get("clouds");
			JSONObject winds = (JSONObject)situation.get("wind");
		weather_conditions w = new weather_conditions();
		float temp = (float)main.get("temp");
		w.setTemp(temp);
		float feels_like = (float)main.get("feels_like");
		w.setFeels_like(feels_like);
		float temp_min = (float)main.get("temp_min");
		w.setTemp_min(temp_min);
		float temp_max = (float)main.get("temp_max");
		w.setTemp_max(temp_max);
		float pressure = (float)main.get("pressure");
		w.setPressure(pressure);
		int humidity =(int)main.get("humidity");
		w.setHumidity(humidity);
		float temp_kf = (float)main.get("temp_kf");
		w.setTemp_kf(temp_kf);
		String condition = (String)effective_weather.get("main");
		w.setCondition(condition);
		String description = (String)effective_weather.get("description");
		w.setDescription(description);
		int cloud = (int)clouds.get("all");
		w.setClouds(cloud);
		int wind_speed =(int)winds.get("speed");
		w.setWind_speed(wind_speed);
		int wind_deg = (int)winds.get("deg");
		w.setWind_deg(wind_deg);
		int visibility = (int)situation.get("visibility");
		w.setVisibility(visibility);
		long dt_txt = (long)situation.get("dt_txt");
		w.setDt_txt(dt_txt);
		results.add(w);
		}
		return results;
	}
	
	/*
	 * questo metodo crea un oggetto weeather_conditions utilizzando i dati attuali ottenuti precedentemente
	 */
	
	public weather_conditions current_fill(String q) throws ParseException {
		weather_conditions results = new weather_conditions();
		JSONObject data = current_weather_data(q);
		JSONObject main = (JSONObject)data.get("main");
		JSONArray weather = (JSONArray)data.get("weather");
		JSONObject effective_weather = (JSONObject)weather.get(0);
		JSONObject clouds=(JSONObject)data.get("clouds");
		JSONObject winds = (JSONObject)data.get("wind");
	
	float temp = (float)main.get("temp");
	results.setTemp(temp);
	float feels_like = (float)main.get("feels_like");
	results.setFeels_like(feels_like);
	float temp_min = (float)main.get("temp_min");
	results.setTemp_min(temp_min);
	float temp_max = (float)main.get("temp_max");
	results.setTemp_max(temp_max);
	float pressure = (float)main.get("pressure");
	results.setPressure(pressure);
	int humidity =(int)main.get("humidity");
	results.setHumidity(humidity);
	float temp_kf = (float)main.get("temp_kf");
	results.setTemp_kf(temp_kf);
	String condition = (String)effective_weather.get("main");
	results.setCondition(condition);
	String description = (String)effective_weather.get("description");
	results.setDescription(description);
	int cloud = (int)clouds.get("all");
	results.setClouds(cloud);
	int wind_speed =(int)winds.get("speed");
	results.setWind_speed(wind_speed);
	int wind_deg = (int)winds.get("deg");
	results.setWind_deg(wind_deg);
	int visibility = (int)data.get("visibility");
	results.setVisibility(visibility);
	long dt_txt = (long)data.get("dt_txt");
	results.setDt_txt(dt_txt);
	
	return results;
	
}
	
	
	//PARTE VECCHIA
		
//			ArrayList<weather_conditions> results = new ArrayList<weather_conditions>();
//			String url = "api.openweathermap.org/data/2.5/forecast?q=" + q +"&appid=" + apiKey ; 
//			String fileName = "";
//			
//			
//			try {
//				
//				URLConnection openConnection = new URL(url).openConnection();
//				InputStream in = openConnection.getInputStream();
//				
//				 String data = "";
//				 String line = "";
//				 try {
//				   InputStreamReader inR = new InputStreamReader( in );
//				   BufferedReader buf = new BufferedReader( inR );
//				  
//				   while ( ( line = buf.readLine() ) != null ) {
//					   data+= line;
//				   }
//				 } finally {
//				   in.close();
//				 }
//				 JSONParser parser = new JSONParser();
//			JSONObject response = (JSONObject)parser.parse(data);
//			JSONArray list = (JSONArray)response.get("list");
				//System.out.println( data );
//			for (Object currents : list) {
//				JSONObject situation = (JSONObject) currents;
//				JSONObject main = (JSONObject)situation.get("main");
//				JSONArray weather = (JSONArray)situation.get("weather");
//				JSONObject effective_weather = (JSONObject)weather.get(0);
//				JSONObject clouds=(JSONObject)situation.get("clouds");
//				JSONObject winds = (JSONObject)situation.get("wind");
//			weather_conditions w = new weather_conditions();
//			float temp = (float)main.get("temp");
//			w.setTemp(temp);
//			float feels_like = (float)main.get("feels_like");
//			w.setFeels_like(feels_like);
//			float temp_min = (float)main.get("temp_min");
//			w.setTemp_min(temp_min);
//			float temp_max = (float)main.get("temp_max");
//			w.setTemp_max(temp_max);
//			float pressure = (float)main.get("pressure");
//			w.setPressure(pressure);
//			int humidity =(int)main.get("humidity");
//			w.setHumidity(humidity);
//			float temp_kf = (float)main.get("temp_kf");
//			w.setTemp_kf(temp_kf);
//			String condition = (String)effective_weather.get("main");
//			w.setCondition(condition);
//			String description = (String)effective_weather.get("description");
//			w.setDescription(description);
//			int cloud = (int)clouds.get("all");
//			w.setClouds(cloud);
//			int wind_speed =(int)winds.get("speed");
//			w.setWind_speed(wind_speed);
//			int wind_deg = (int)winds.get("deg");
//			w.setWind_deg(wind_deg);
//			int visibility = (int)situation.get("visibility");
//			w.setVisibility(visibility);
//			long dt_txt = (long)situation.get("dt_txt");
//			w.setDt_txt(dt_txt);
//			results.add(w);
//			}
//			return results;
//				//JSONArray obj = (JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
//				//JSONObject obj = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
//				//System.out.println( "OK" );
//			} catch (IOException | ParseException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return results;
//		}
//	


	

	
//	public static weather_conditions current_weather_data (String q, String apiKey) throws ParseException {
//		BufferedReader reader;
//		String line="";
//		StringBuffer responseContent = new StringBuffer();
//		URL url;
//		weather_conditions results = new weather_conditions();
//		try {
//			url = new URL("api.openweathermap.org/data/2.5/weather?q="+ q +"&appid=" + apiKey + "&format=json");
//		connection =(HttpURLConnection)url.openConnection();
//		connection.setRequestMethod("GET");
//		connection.setConnectTimeout(5000);
//		connection.setReadTimeout(5000);
//		int status=connection.getResponseCode();
//		
//		if(status>299) {
//			reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//			while ((line=reader.readLine())!= null) {
//				responseContent.append(line);
//			}
//			reader.close();
//		}
//		else {
//			reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			
//			while ((line=reader.readLine())!= null) {
//				responseContent.append(line);
//			}
//			reader.close();
//			JSONParser parser = new JSONParser();
//			JSONObject response = (JSONObject)parser.parse(responseContent.toString());
//			
//			/*
//			 * iterazione che va a prendere gli oggetti presenti all'interno della risposta alla
//			 * chiamata API e li inserisce in un weather_conditions che rappresenta le condizioni
//			 * meteo attuali
//			 */
//			
//				
//				JSONObject main = (JSONObject)response.get("main");
//				JSONArray weather = (JSONArray)response.get("weather");
//				JSONObject effective_weather = (JSONObject)weather.get(0);
//				JSONObject clouds=(JSONObject)response.get("clouds");
//				JSONObject winds = (JSONObject)response.get("wind");
//			
//			float temp = (float)main.get("temp");
//			results.setTemp(temp);
//			float feels_like = (float)main.get("feels_like");
//			results.setFeels_like(feels_like);
//			float temp_min = (float)main.get("temp_min");
//			results.setTemp_min(temp_min);
//			float temp_max = (float)main.get("temp_max");
//			results.setTemp_max(temp_max);
//			float pressure = (float)main.get("pressure");
//			results.setPressure(pressure);
//			int humidity =(int)main.get("humidity");
//			results.setHumidity(humidity);
//			float temp_kf = (float)main.get("temp_kf");
//			results.setTemp_kf(temp_kf);
//			String condition = (String)effective_weather.get("main");
//			results.setCondition(condition);
//			String description = (String)effective_weather.get("description");
//			results.setDescription(description);
//			int cloud = (int)clouds.get("all");
//			results.setClouds(cloud);
//			int wind_speed =(int)winds.get("speed");
//			results.setWind_speed(wind_speed);
//			int wind_deg = (int)winds.get("deg");
//			results.setWind_deg(wind_deg);
//			int visibility = (int)response.get("visibility");
//			results.setVisibility(visibility);
//			long dt_txt = (long)response.get("dt_txt");
//			results.setDt_txt(dt_txt);
//			
//			
//		}
//		}
//
//		catch (MalformedURLException e) {
//			e.printStackTrace();
//}catch (IOException e) {
//e.printStackTrace();
//}finally {
//connection.disconnect();
//}
///*
// * restituzione del weather_conditions appena creato
// */
//return results;
//
//
//	}	
}