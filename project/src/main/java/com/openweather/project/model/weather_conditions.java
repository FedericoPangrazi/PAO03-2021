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
private double temp;
private double feels_like;
private double temp_min;
private double temp_max;
private double pressure;
private double humidity;
private double temp_kf;
private String condition; //clouds, sunny ecc.
private String description;
private double clouds;
private double wind_speed;
private double wind_deg;
private double visibility;
private String dt_txt;
/**
 * @return the temp
 */
public double getTemp() {
	return temp;
}
/**
 * @param temp2 the temp to set
 */
public void setTemp(double temp2) {
	this.temp = temp2;
}
/**
 * @return the feels_like
 */
public double getFeels_like() {
	return feels_like;
}
/**
 * @param feels_like2 the feels_like to set
 */
public void setFeels_like(double feels_like2) {
	this.feels_like = feels_like2;
}
/**
 * @return the temp_min
 */
public double getTemp_min() {
	return temp_min;
}
/**
 * @param temp_min2 the temp_min to set
 */
public void setTemp_min(double temp_min2) {
	this.temp_min = temp_min2;
}
/**
 * @return the temp_max
 */
public double getTemp_max() {
	return temp_max;
}
/**
 * @param temp_max2 the temp_max to set
 */
public void setTemp_max(double temp_max2) {
	this.temp_max = temp_max2;
}
/**
 * @return the pressure
 */
public double getPressure() {
	return pressure;
}
/**
 * @param pressure2 the pressure to set
 */
public void setPressure(double pressure2) {
	this.pressure = pressure2;
}
/**
 * @return the humidity
 */
public double getHumidity() {
	return humidity;
}
/**
 * @param humidity2 the humidity to set
 */
public void setHumidity(double humidity2) {
	this.humidity = humidity2;
}
/**
 * @return the temp_kf
 */
public double getTemp_kf() {
	return temp_kf;
}
/**
 * @param temp_kf2 the temp_kf to set
 */
public void setTemp_kf(double temp_kf2) {
	this.temp_kf = temp_kf2;
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
public double getClouds() {
	return clouds;
}
/**
 * @param cloud the clouds to set
 */
public void setClouds(double cloud) {
	this.clouds = cloud;
}
/**
 * @return the wind_speed
 */
public double getWind_speed() {
	return wind_speed;
}
/**
 * @param wind_speed2 the wind_speed to set
 */
public void setWind_speed(double wind_speed2) {
	this.wind_speed = wind_speed2;
}
/**
 * @return the wind_deg
 */
public double getWind_deg() {
	return wind_deg;
}
/**
 * @param wind_deg2 the wind_deg to set
 */
public void setWind_deg(double wind_deg2) {
	this.wind_deg = wind_deg2;
}
/**
 * @return the visibility
 */
public double getVisibility() {
	return visibility;
}
/**
 * @param visibility2 the visibility to set
 */
public void setVisibility(double visibility2) {
	this.visibility = visibility2;
}
/**
 * @return the dt_txt
 */
public String getDt_txt() {
	return dt_txt;
}
/**
 * @param dt the dt_txt to set
 */
public void setDt_txt(String dt) {
	this.dt_txt = dt;
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
	this.dt_txt = "";
} 

}
