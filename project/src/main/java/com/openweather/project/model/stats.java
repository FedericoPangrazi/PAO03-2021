/**
 * 
 */
package com.openweather.project.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author frede
 *
 */
public class stats {
	private ArrayList<Double> temp;
	private ArrayList<Double> pressure;
	private ArrayList<Double> clouds;
	private SimpleDateFormat date;
	private int counter;
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 */
	public stats() {
		super();
		this.temp = null;
		this.pressure = null;
		this.clouds = null;
		this.date=null;
		this.counter=0;
	}
	/**
	 * @return the first_date
	 */
	public SimpleDateFormat getdate() {
		return date;
	}
	/**
	 * @param first_date the first_date to set
	 */
	public void setdate(SimpleDateFormat date) {
		this.date = date;
	}
	
	
	/**
	 * @return the temp
	 */
	public ArrayList<Double> getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
	  this.temp.add(temp);
	}
	/**
	 * @return the pressure
	 */
	public ArrayList<Double> getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure.add(pressure);
	}
	/**
	 * @return the clouds
	 */
	public ArrayList<Double> getClouds() {
		return clouds;
	}
	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(double clouds) {
		this.clouds.add(clouds);
	}
	

}
