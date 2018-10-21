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
		
		PiData model = DataService.getData();
		String jObject = new Gson().toJson(model);
		System.out.println("From DB: " + jObject);
		
		// now to send it
		int result = BrendansRoomTemperatureController.send(model);
		System.out.println("Result: " + result);
	}
}
