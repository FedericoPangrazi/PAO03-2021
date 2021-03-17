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

/**
 * questa classe serve ad ottenere i dati dal server riguardo le previsioni e le condizioni attuali e ad integrarli in 
 * strutture dati create appositamente
 */

public class parser {

	private static final String apiKey = "0b1a0a7aebf19e0cbbe68d82742bdf97";
	
/**
 * questo metodo ottiene i dati delle previsioni per i prossimi 5 giorni dalla
 chiamata API e li restituisce come un JSONObject
 * @param q la città richiesta
 * @return response 
 * @throws ParseException exception
 */
	public static JSONObject forecast_weather_data(String q) throws ParseException {
		JSONObject response;
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + q + "&appid=" + apiKey;
		RestTemplate appoggio = new RestTemplate();
		response = new JSONObject(appoggio.getForObject(url, String.class));
		return response;
	}
	
/**
 * questo metodo ottiene i dati delle condizioni meteo attuali dalla chiamata
 API e li restituisce come un JSONObject
 * @param q la città richiesta
 * @return response 
 * @throws ParseException exception
 */
	public static JSONObject current_weather_data(String q) throws ParseException {
		JSONObject response;
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + q + "&appid=" + apiKey;
		RestTemplate appoggio = new RestTemplate();
		response = new JSONObject(appoggio.getForObject(url, String.class));
		return response;
	}

	
/**
 * questo metodo riempie un ArrayList di weather_conditions con i dati delle
 previsioni precedentemente ottenuti
 * @param q la città richiesta
 * @return results
 * @throws ParseException exception
 */
	public static ArrayList<weather_conditions> forecast_fill(String q) throws ParseException {
		ArrayList<weather_conditions> results = new ArrayList<weather_conditions>();
		JSONObject data = forecast_weather_data(q);
		JSONArray list = (JSONArray) data.get("list");
		for (Object currents : list) {
			JSONObject situation = (JSONObject) currents;
			JSONObject main = (JSONObject) situation.get("main");
			JSONArray weather = (JSONArray) situation.get("weather");
			JSONObject effective_weather = (JSONObject) weather.get(0);
			JSONObject clouds = (JSONObject) situation.get("clouds");
			JSONObject winds = (JSONObject) situation.get("wind");
			weather_conditions w = new weather_conditions();
			/**
			 * è necessario il check di tipo delle variabili ottenute ed eventualmente il
			 * loro casting per poterle inserire in un oggetto weather_conditions
			 */

			Object t = (Object) main.get("temp");
			if (t instanceof Double) {
				double temp = (double) t;
				w.setTemp(temp);
			} else if (t instanceof Long) {
				Long temp = (Long) t;
				double dtemp = temp.doubleValue();
				w.setTemp(dtemp);
			}

			Object fl = (Object) main.get("feels_like");
			if (fl instanceof Double) {
				double feels_like = (double) fl;
				w.setFeels_like(feels_like);
			} else if (fl instanceof Long) {
				Long feels_like = (Long) fl;
				double dfl = feels_like.doubleValue();
				w.setFeels_like(dfl);
			}

			Object tmin = (Object) main.get("temp_min");
			if (tmin instanceof Double) {
				double temp_min = (double) tmin;
				w.setTemp_min(temp_min);
			} else if (tmin instanceof Long) {
				Long ltmin = (Long) tmin;
				double dtmin = ltmin.doubleValue();
				w.setTemp_min(dtmin);
			}

			Object tmax = (Object) main.get("temp_max");
			if (tmax instanceof Double) {
				double temp_max = (double) tmax;
				w.setTemp_max(temp_max);
			} else if (tmax instanceof Long) {
				Long ltmax = (Long) tmax;
				double dtmax = ltmax.doubleValue();
				w.setTemp_max(dtmax);
			}

			Object pr = (Object) main.get("pressure");
			if (pr instanceof Double) {
				double pressure = (double) pr;
				w.setPressure(pressure);
			} else if (pr instanceof Long) {
				Long lpr = (Long) pr;
				double dpr = lpr.doubleValue();
				w.setPressure(dpr);
			} else if (pr instanceof Integer) {
				Integer ipr = (Integer) pr;
				double dpr = ipr.doubleValue();
				w.setPressure(dpr);
			} else if (pr instanceof Short) {
				Short spr = (Short) pr;
				double dpr = spr.doubleValue();
				w.setPressure(dpr);
			}

			Object hum = (Object) main.get("humidity");
			if (hum instanceof Double) {
				double humidity = (double) hum;
				w.setHumidity(humidity);
			} else if (hum instanceof Long) {
				Long lhum = (Long) hum;
				double dhum = lhum.doubleValue();
				w.setHumidity(dhum);
			}
			else if(hum instanceof Integer) {
				Integer ihum=(Integer)hum;
				double dhum=ihum.doubleValue();
				w.setHumidity(dhum);
			}

			Object tkf = (Object) main.get("temp_kf");
			if (tkf instanceof Double) {
				double temp_kf = (double) tkf;
				w.setTemp_kf(temp_kf);
			} else if (tkf instanceof Long) {
				Long ltkf = (Long) tkf;
				double dtkf = ltkf.doubleValue();
				w.setTemp_kf(dtkf);
			}

			String condition = (String) effective_weather.get("main");
			w.setCondition(condition);
			String description = (String) effective_weather.get("description");
			w.setDescription(description);

			Object cl = (Object) clouds.get("all");
			if (cl instanceof Double) {
				double cloud = (double) cl;
				w.setClouds(cloud);
			} else if (cl instanceof Long) {
				Long lcl = (Long) cl;
				double dcl = lcl.doubleValue();
				w.setClouds(dcl);
			}
			else if(cl instanceof Integer) {
				Integer icl=(Integer)cl;
				double dcl=icl.doubleValue();
				w.setClouds(dcl);
			}

			Object ws = (Object) winds.get("speed");
			if (ws instanceof Double) {
				double wind_speed = (double) ws;
				w.setWind_speed(wind_speed);
			} else if (ws instanceof Long) {
				Long lws = (Long) ws;
				double dws = lws.doubleValue();
				w.setWind_speed(dws);
			}

			Object wd = (Object) winds.get("deg");
			if (wd instanceof Double) {
				double wind_deg = (double) wd;
				w.setWind_deg(wind_deg);
			} else if (wd instanceof Long) {
				Long lwd = (Long) wd;
				double dwd = lwd.doubleValue();
				w.setWind_deg(dwd);
			}
			else if(wd instanceof Integer) {
				Integer iwd=(Integer)wd;
				double dwd=iwd.doubleValue();
				w.setWind_deg(dwd);
			}

			Object vis = (Object) situation.get("visibility");
			if (vis instanceof Double) {
				double visibility = (double) vis;
				w.setVisibility(visibility);
			} else if (vis instanceof Long) {
				Long lvis = (Long) vis;
				double dvis = lvis.doubleValue();
				w.setVisibility(dvis);
			}
			else if (vis instanceof Integer) {
				Integer ivis=(Integer)vis;
				double dvis=ivis.doubleValue();
				w.setVisibility(dvis);
			}

			String dt = (String) situation.get("dt_txt");
			w.setDt_txt(dt);

			results.add(w);
		}
		return results;
	}

	
/**
 * questo metodo crea un oggetto weather_conditions utilizzando i dati attuali
	 ottenuti precedentemente
 * @param q la città richiesta
 * @return results
 * @throws ParseException exception
 */
	public static weather_conditions current_fill(String q) throws ParseException {
		weather_conditions results = new weather_conditions();
		JSONObject data = current_weather_data(q);
		JSONObject main = (JSONObject) data.get("main");
		JSONArray weather = (JSONArray) data.get("weather");
		JSONObject effective_weather = (JSONObject) weather.get(0);
		JSONObject clouds = (JSONObject) data.get("clouds");
		JSONObject winds = (JSONObject) data.get("wind");

		Object t = (Object) main.get("temp");
		if (t instanceof Double) {
			double temp = (double) t;
			results.setTemp(temp);
		} else if (t instanceof Long) {
			Long temp = (Long) t;
			double dtemp = temp.doubleValue();
			results.setTemp(dtemp);
		}

		Object fl = (Object) main.get("feels_like");
		if (fl instanceof Double) {
			double feels_like = (double) fl;
			results.setFeels_like(feels_like);
		} else if (fl instanceof Long) {
			Long feels_like = (Long) fl;
			double dfl = feels_like.doubleValue();
			results.setFeels_like(dfl);
		}

		Object tmin = (Object) main.get("temp_min");
		if (tmin instanceof Double) {
			double temp_min = (double) tmin;
			results.setTemp_min(temp_min);
		} else if (tmin instanceof Long) {
			Long ltmin = (Long) tmin;
			double dtmin = ltmin.doubleValue();
			results.setTemp_min(dtmin);
		}

		Object tmax = (Object) main.get("temp_max");
		if (tmax instanceof Double) {
			double temp_max = (double) tmax;
			results.setTemp_max(temp_max);
		} else if (tmax instanceof Long) {
			Long ltmax = (Long) tmax;
			double dtmax = ltmax.doubleValue();
			results.setTemp_max(dtmax);
		}

		Object pr = (Object) main.get("pressure");
		if (pr instanceof Double) {
			double pressure = (double) pr;
			results.setPressure(pressure);
		} else if (pr instanceof Long) {
			Long lpr = (Long) pr;
			double dpr = lpr.doubleValue();
			results.setPressure(dpr);
		} else if (pr instanceof Integer) {
			Integer ipr = (Integer) pr;
			double dpr = ipr.doubleValue();
			results.setPressure(dpr);
		} else if (pr instanceof Short) {
			Short spr = (Short) pr;
			double dpr = spr.doubleValue();
			results.setPressure(dpr);
		}

		Object hum = (Object) main.get("humidity");
		if (hum instanceof Double) {
			double humidity = (double) hum;
			results.setHumidity(humidity);
		} else if (hum instanceof Long) {
			Long lhum = (Long) hum;
			double dhum = lhum.doubleValue();
			results.setHumidity(dhum);
		}
		 if (hum instanceof Integer) {
			Integer ihum = (Integer) hum;
			double dhum = ihum.doubleValue();
			results.setHumidity(dhum);
		}
		
		String condition = (String) effective_weather.get("main");
		results.setCondition(condition);
		String description = (String) effective_weather.get("description");
		results.setDescription(description);

		Object cl = (Object) clouds.get("all");
		if (cl instanceof Double) {
			double cloud = (double) cl;
			results.setClouds(cloud);
		} else if (cl instanceof Long) {
			Long lcl = (Long) cl;
			double dcl = lcl.doubleValue();
			results.setClouds(dcl);
		}
		else if(cl instanceof Integer) {
			Integer icl=(Integer) cl;
			double dcl=icl.doubleValue();
			results.setClouds(dcl);
		}

		Object ws = (Object) winds.get("speed");
		if (ws instanceof Double) {
			double wind_speed = (double) ws;
			results.setWind_speed(wind_speed);
		} else if (ws instanceof Long) {
			Long lws = (Long) ws;
			double dws = lws.doubleValue();
			results.setWind_speed(dws);
		}

		Object wd = (Object) winds.get("deg");
		if (wd instanceof Double) {
			double wind_deg = (double) wd;
			results.setWind_deg(wind_deg);
		} else if (wd instanceof Long) {
			Long lwd = (Long) wd;
			double dwd = lwd.doubleValue();
			results.setWind_deg(dwd);
		} else if (wd instanceof Integer) {
			
			Integer iwd = (Integer) wd;
			double dwd = iwd.doubleValue();
			results.setWind_deg(dwd);
		} 

		Object vis = (Object) data.get("visibility");
		if (vis instanceof Double) {
			double visibility = (double) vis;
			results.setVisibility(visibility);
		} else if (vis instanceof Long) {
			Long lvis = (Long) vis;
			double dvis = lvis.doubleValue();
			results.setVisibility(dvis);
		} else if (vis instanceof Integer) {
			Integer ivis = (Integer) vis;
			double dvis = ivis.doubleValue();
			results.setVisibility(dvis);
		}
        
		Object dt=(Object)data.get("dt");
		if(dt instanceof Integer) {
			Integer idt=(Integer)dt;
			String sdt=idt.toString();
			results.setDt_txt(sdt);
		}
		else if(dt instanceof Double) {
			Double ddt =(Double)dt;
			String sdt=ddt.toString();
			results.setDt_txt(sdt);
		}
		 return results;
		 
	}
	
	
/**
 * questo metodo stampa una stringa contenente i dati delle condizioni attuali presi da current_fill sotto forma di stringa,
 * che verrà poi salvata nello storico (file di testo) 
 * @param q la città richiesta
 * @return stamp
 * @throws ParseException exception
 */
	public static String current_Stamper(String q) throws ParseException {
		weather_conditions w = current_fill(q);
		String stamp = "Current" + " " + q + " " + "conditions:" + "\n" + "Temperature is: " + w.getTemp() + "°k" + "\n"
				+ "But it feels like: " + w.getFeels_like() + "°k" + "\n" + "The minimum and maximum temperature are:"
				+ w.getTemp_min() + "°k and " + w.getTemp_max() + "°k" + "\n" + "The pressure is: " + w.getPressure()
				+ " bar " + "\n" + "The humidity is of " + w.getHumidity() + "% " + "\n" + "The weather is "
				+ w.getCondition() + " (" + w.getDescription() + ")" + "\n" + "The clouds' level is(in percentage): "
				+ w.getClouds() + "\n" + "The wind is blowing at " + w.getWind_speed()
				+ " mph and its direction's degree is of " + w.getWind_deg() + "\n" + "The visibility level is "
				+ w.getVisibility() + "m " + "\n";
		return stamp;

	}
	
	
	
	/**
	 * /*
	 * questo metodo crea un JSONObject con i dati utili a generare le statistiche
	 * @param q la città richiesta
	 * @return stats
	 * @throws ParseException exception
	 */
	public static JSONObject current_stat_generator(String q) throws ParseException {
		weather_conditions w=current_fill(q);
		String results = "{\"temp\":\""+w.getTemp()+"\",\"pressure\":\""+w.getPressure()+"\",\"clouds\":\""+w.getClouds()+"\",\"date\":\""+w.getDt_txt()+"\"}";
		JSONObject stats=new JSONObject(results);
		return stats;
	}
	
	
	
/**
 * *
 * questo metodo stampa una stringa contenente i dati delle previsioni meteo ottenuti da forecast_fill
 * @param q la città richiesta
 * @return stamp
 * @throws ParseException exception
 */
	public static String forecast_Stamper(String q) throws ParseException {
		ArrayList<weather_conditions> w = forecast_fill(q);
		String stamp = "";
		for (weather_conditions counter : w) {
			String singular = "The weather predictions for " + counter.getDt_txt() + " in " + q + " are:" + "\n"
					+ "Temperature is: " + counter.getTemp() + "°k" + "\n" + "But it feels like: "
					+ counter.getFeels_like() + "°k" + "\n" + "The minimum and maximum temperature are:"
					+ counter.getTemp_min() + "°k and " + counter.getTemp_max() + "°k" + "\n" + "The pressure is: "
					+ counter.getPressure() + " bar " + "\n" + "The humidity is of " + counter.getHumidity() + "% "
					+ "\n" + "The weather is " + counter.getCondition() + " (" + counter.getDescription() + ")" + "\n"
					+ "The clouds' level is(in percentage): " + counter.getClouds() + "\n" + "The wind is blowing at "
					+ counter.getWind_speed() + " mph and its direction's degree is of " + counter.getWind_deg() + "\n"
					+ "The visibility level is " + counter.getVisibility() + "m " + "\n";
			stamp = stamp + singular + "\n";
		}

		return stamp;
	}
	
}
