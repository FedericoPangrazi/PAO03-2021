/**
 * 
 */
package com.openweather.project.model;

import java.io.Serializable;

/**
 * @author frede
 *
 */
public class weather_conditions implements Serializable {
	static final long serialVersionUID = 1;
private float temp;
private float feels_like;
private float temp_min;
private float temp_max;
private float pressure;
private int humidity;
private float temp_kf;
private String condition; //clouds, sunny ecc.
private String description;
private int clouds;
private int wind_speed;
private int wind_deg;
private int visibility;
private long dt_txt;
/**
 * @return the temp
 */
public float getTemp() {
	return temp;
}
/**
 * @param temp the temp to set
 */
public void setTemp(float temp) {
	this.temp = temp;
}
/**
 * @return the feels_like
 */
public float getFeels_like() {
	return feels_like;
}
/**
 * @param feels_like the feels_like to set
 */
public void setFeels_like(float feels_like) {
	this.feels_like = feels_like;
}
/**
 * @return the temp_min
 */
public float getTemp_min() {
	return temp_min;
}
/**
 * @param temp_min the temp_min to set
 */
public void setTemp_min(float temp_min) {
	this.temp_min = temp_min;
}
/**
 * @return the temp_max
 */
public float getTemp_max() {
	return temp_max;
}
/**
 * @param temp_max the temp_max to set
 */
public void setTemp_max(float temp_max) {
	this.temp_max = temp_max;
}
/**
 * @return the pressure
 */
public float getPressure() {
	return pressure;
}
/**
 * @param pressure the pressure to set
 */
public void setPressure(float pressure) {
	this.pressure = pressure;
}
/**
 * @return the humidity
 */
public int getHumidity() {
	return humidity;
}
/**
 * @param humidity the humidity to set
 */
public void setHumidity(int humidity) {
	this.humidity = humidity;
}
/**
 * @return the temp_kf
 */
public float getTemp_kf() {
	return temp_kf;
}
/**
 * @param temp_kf the temp_kf to set
 */
public void setTemp_kf(float temp_kf) {
	this.temp_kf = temp_kf;
}
/**
 * @return the condition
 */
public String getCondition() {
	return condition;
}
/**
 * @param condition the condition to set
 */
public void setCondition(String condition) {
	this.condition = condition;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * @return the clouds
 */
public int getClouds() {
	return clouds;
}
/**
 * @param clouds the clouds to set
 */
public void setClouds(int clouds) {
	this.clouds = clouds;
}
/**
 * @return the wind_speed
 */
public int getWind_speed() {
	return wind_speed;
}
/**
 * @param wind_speed the wind_speed to set
 */
public void setWind_speed(int wind_speed) {
	this.wind_speed = wind_speed;
}
/**
 * @return the wind_deg
 */
public int getWind_deg() {
	return wind_deg;
}
/**
 * @param wind_deg the wind_deg to set
 */
public void setWind_deg(int wind_deg) {
	this.wind_deg = wind_deg;
}
/**
 * @return the visibility
 */
public int getVisibility() {
	return visibility;
}
/**
 * @param visibility the visibility to set
 */
public void setVisibility(int visibility) {
	this.visibility = visibility;
}
/**
 * @return the dt_txt
 */
public long getDt_txt() {
	return dt_txt;
}
/**
 * @param dt_txt the dt_txt to set
 */
public void setDt_txt(long dt_txt) {
	this.dt_txt = dt_txt;
}
/**
 * @param temp
 * @param feels_like
 * @param temp_min
 * @param temp_max
 * @param pressure
 * @param humidity
 * @param temp_kf
 * @param condition
 * @param description
 * @param clouds
 * @param wind_speed
 * @param wind_deg
 * @param visibility
 * @param dt_txt
 */
public weather_conditions() {
	this.temp = 0;
	this.feels_like = 0;
	this.temp_min = 0;
	this.temp_max = 0;
	this.pressure = 0;
	this.humidity = 0;
	this.temp_kf = 0;
	this.condition = "";
	this.description = "";
	this.clouds = 0;
	this.wind_speed = 0;
	this.wind_deg = 0;
	this.visibility = 0;
	this.dt_txt = 0;
} 

}
