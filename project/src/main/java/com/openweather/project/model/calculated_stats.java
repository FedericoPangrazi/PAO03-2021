/**
 * 
 */
package com.openweather.project.model;

/**
 * @author frede
 *
 */
public class calculated_stats {
private double min_temp;
private double max_temp;
private double min_pres;
private double max_pres;
private double min_cloud;
private double max_cloud;
private double media_temp;
private double media_pres;
private double media_cloud;
private double var_temp;
private double var_pres;
private double var_cloud;
/** 
 * @param min_temp la temperatura minima
 * @param max_temp la temperatura massima
 * @param min_pres la pressione minima 
 * @param max_pres la pressione massima
 * @param min_cloud la nuvolosità minima
 * @param max_cloud la nuvolosità massima
 * @param media_temp la temperatura media
 * @param media_pres la pressione media
 * @param media_cloud la nuvolosità media
 * @param var_temp la varianza della temperatura
 * @param var_pres la varianza della pressione
 * @param var_cloud la varianza della nuvolosità
 */
public calculated_stats() {
	super();
	this.min_temp = 0;
	this.max_temp = 0;
	this.min_pres = 0;
	this.max_pres = 0;
	this.min_cloud = 0;
	this.max_cloud = 0;
	this.media_temp = 0;
	this.media_pres = 0;
	this.media_cloud = 0;
	this.var_temp = 0;
	this.var_pres = 0;
	this.var_cloud = 0;
}
/**
 * @return the min_temp
 */
public double getMin_temp() {
	return min_temp;
}
/**
 * @param min_temp the min_temp to set
 */
public void setMin_temp(double min_temp) {
	this.min_temp = min_temp;
}
/**
 * @return the max_temp
 */
public double getMax_temp() {
	return max_temp;
}
/**
 * @param max_temp the max_temp to set
 */
public void setMax_temp(double max_temp) {
	this.max_temp = max_temp;
}
/**
 * @return the min_pres
 */
public double getMin_pres() {
	return min_pres;
}
/**
 * @param min_pres the min_pres to set
 */
public void setMin_pres(double min_pres) {
	this.min_pres = min_pres;
}
/**
 * @return the max_pres
 */
public double getMax_pres() {
	return max_pres;
}
/**
 * @param max_pres the max_pres to set
 */
public void setMax_pres(double max_pres) {
	this.max_pres = max_pres;
}
/**
 * @return the min_cloud
 */
public double getMin_cloud() {
	return min_cloud;
}
/**
 * @param min_cloud the min_cloud to set
 */
public void setMin_cloud(double min_cloud) {
	this.min_cloud = min_cloud;
}
/**
 * @return the max_cloud
 */
public double getMax_cloud() {
	return max_cloud;
}
/**
 * @param max_cloud the max_cloud to set
 */
public void setMax_cloud(double max_cloud) {
	this.max_cloud = max_cloud;
}
/**
 * @return the media_temp
 */
public double getMedia_temp() {
	return media_temp;
}
/**
 * @param media_temp the media_temp to set
 */
public void setMedia_temp(double media_temp) {
	this.media_temp = media_temp;
}
/**
 * @return the media_pres
 */
public double getMedia_pres() {
	return media_pres;
}
/**
 * @param media_pres the media_pres to set
 */
public void setMedia_pres(double media_pres) {
	this.media_pres = media_pres;
}
/**
 * @return the media_cloud
 */
public double getMedia_cloud() {
	return media_cloud;
}
/**
 * @param media_cloud the media_cloud to set
 */
public void setMedia_cloud(double media_cloud) {
	this.media_cloud = media_cloud;
}
/**
 * @return the var_temp
 */
public double getVar_temp() {
	return var_temp;
}
/**
 * @param var_temp the var_temp to set
 */
public void setVar_temp(double var_temp) {
	this.var_temp = var_temp;
}
/**
 * @return the var_pres
 */
public double getVar_pres() {
	return var_pres;
}
/**
 * @param var_pres the var_pres to set
 */
public void setVar_pres(double var_pres) {
	this.var_pres = var_pres;
}
/**
 * @return the var_cloud
 */
public double getVar_cloud() {
	return var_cloud;
}
/**
 * @param var_cloud the var_cloud to set
 */
public void setVar_cloud(double var_cloud) {
	this.var_cloud = var_cloud;
}

}
