/**
 * Connor Low
 * CST-
 * Sep 28, 2018
 * This is my own work.
 */
package api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Handle requests to the OpenWeatherMap API.
 */
public class WeatherController {

	private final String API_KEY = "c146c555bdb232e9ea79bfd7de23a144";
	private final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

	public String getStringTest() {
		return getStringTest("London");
	}

	/**
	 * Sends a GET request to the OpenWeatherMap API.
	 * 
	 * @return a JSON String of the response.
	 */
	public String getStringTest(String city) {
		String requestLocation = getUrlForCity(city);
		try {

			// create and open a connection
			URL url = new URL(requestLocation);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// execute request
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// get response
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			return response.toString();
		} catch (MalformedURLException e) {

			// catch bad urls
			e.printStackTrace();
			return "ERROR: Could not complete request - url malformed.";
		} catch (IOException e) {

			// catch connection output and reader errors
			e.printStackTrace();
			return "ERROR: Could not complete request - and IO exception occured.";
		} catch (Exception e) {

			// catch all other exceptions that might come up
			return "ERROR: Could not complete request for an unknown reason.";
		}
	}

	/**
	 * Create a API request url for a city.
	 * 
	 * @param city
	 * @return a url represented as a String.
	 */
	public String getUrlForCity(String city) {
		return String.format("%s?APPID=%s&q=%s", API_URL, API_KEY, city);
	}

}
