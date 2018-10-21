/**
 * Connor Low
 * CST-
 * Oct 18, 2018
 * This is my own work.
 */
package api.models;

import java.sql.Date;

/**
 * @author speed
 *
 */
public class PiData {
	int id;
	int temperature;
	Date date;

	public PiData() {
		super();
		this.id = -1;
		this.temperature = -1;
		this.date = new Date(0L);
	}

	public PiData(int id, int temp, Date date) {
		this.id = id;
		this.temperature = temp;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temp) {
		this.temperature = temp;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PiData [id=" + id + ", temp=" + temperature + ", date=" + date + "]";
	}

}
