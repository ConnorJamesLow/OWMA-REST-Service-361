/**
 * Connor Low
 * CST-
 * Sep 28, 2018
 * This is my own work.
 */
package api.main;

import com.google.gson.Gson;

import api.controller.BrendansRoomTemperatureController;
import api.models.PiData;
import api.service.DataService;

/**
 * @author speed
 *
 */
public class Program {
	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			magic();
			Thread.sleep(10 * 60 * 1000);
		}
	}
	
	private static void magic() {
		
		// get most recent data
		PiData model = DataService.getData();
		
		// print out the result as json
		String jObject = new Gson().toJson(model);
		System.out.println("From DB: " + jObject);
		
		// send the model to the reporting application
		int result = BrendansRoomTemperatureController.send(model);
		System.out.println("Result: " + result);
	}
}
