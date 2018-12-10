package api.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class PiData {
	int id;
	int temperature;
	String date;

	public PiData() {
		super();
		this.id = -1;
		this.temperature = -1;
		this.date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Timestamp(0L)).toString();
	}

	public PiData(int id, int temp, Timestamp date) {
		this.id = id;
		this.temperature = temp;
		this.date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(date).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the temperature
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(date).toString();
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
