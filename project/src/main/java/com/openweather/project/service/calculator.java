/**
 * 
 */
package com.openweather.project.service;

import java.io.IOException;
import java.text.ParseException;

import com.openweather.project.model.calculated_stats;
import com.openweather.project.model.stats;

/**
 * @author frede
 *
 */
public class calculator {
	
	/**
	 * metodo per effettuare tutti calcoli nelle variabili presenti nell'oggetto stats, ovvero massimo e minimo,media e varianza
	 * ma solo se il periodo inserito dall'utente è accettabile, cioè non supera il numero di giorni di cui è stato salvato
	 * il database
	 * @param q
	 * @param period
	 * @return results
	 * @throws ParseException
	 * @throws org.json.simple.parser.ParseException
	 * @throws IOException
	 */
public static calculated_stats S_calculator(String q,int period) throws ParseException, org.json.simple.parser.ParseException, IOException{
	stats imported = filereader.stats_filler(q);
	calculated_stats results = new calculated_stats();
	int effective_number = imported.getCounter();
	if(period<5) {
	int requested_number=effective_number-period;
	double min_temp=0;
	double max_temp=0;
	double min_pres=0;
	double max_pres=0;
	double min_cloud=0;
	double max_cloud=0;
	double mid_temp=0;
	double mid_pres=0;
	double mid_cloud=0;
	double var_temp=0;
	double var_pres=0;
	double var_cloud=0;
	double quad_temp=0;
	double quad_pres=0;
	double quad_cloud=0;
	for(int i=0; i < requested_number; i++ ) {
		double temp_value = (double)imported.getTemp().get(i);
		if(max_temp < temp_value) {
			max_temp=temp_value;
		}
		else if(max_temp > temp_value){
			min_temp=temp_value;
		}
		double pres_value=(double)imported.getPressure().get(i);
		if(max_pres < pres_value) {
			max_pres=temp_value;
		}
		else if(max_pres > pres_value) {
			min_pres=pres_value;
	}
		double cloud_value=(double)imported.getClouds().get(i);
		if(max_cloud < cloud_value) {
			max_cloud=cloud_value;
		}
		else if(max_cloud > cloud_value) {
			min_cloud=cloud_value;
	}
}
	results.setMax_temp(max_temp);
	results.setMin_temp(min_temp);
	results.setMax_pres(max_pres);
	results.setMin_pres(min_pres);
	results.setMax_cloud(max_cloud);
	results.setMin_cloud(min_cloud);
	mid_temp=(max_temp-min_temp)/(double)requested_number;
	results.setMedia_temp(mid_temp);
	mid_pres=(max_pres-min_pres)/(double)requested_number;
	results.setMedia_pres(mid_pres);
	mid_cloud=(max_cloud-min_cloud)/(double)requested_number;
	results.setMedia_cloud(mid_cloud);
	for(int i=0; i < requested_number; i++) {
		double temp_value = (double)imported.getTemp().get(i);
		double pres_value=(double)imported.getPressure().get(i);
		double cloud_value=(double)imported.getClouds().get(i);
		quad_temp+=(temp_value-mid_temp);
		quad_pres+=(pres_value-mid_pres);
		quad_cloud+=(cloud_value-mid_cloud);
	}
	var_temp=quad_temp/(double)requested_number;
	var_pres=quad_pres/(double)requested_number;
	var_cloud=quad_cloud/(double)requested_number;
	results.setVar_temp(var_temp);
	results.setVar_pres(var_pres);
	results.setVar_cloud(var_cloud);
	
}
	return results;
}
 
}
