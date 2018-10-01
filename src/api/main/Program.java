/**
 * Connor Low
 * CST-
 * Sep 28, 2018
 * This is my own work.
 */
package api.main;

import java.util.Scanner;

import api.controller.WeatherController;

/**
 * @author speed
 *
 */
public class Program {
	public static void main(String[] args) throws InterruptedException {
		
		// create controller
		WeatherController controller = new WeatherController();
		System.out.println("\tGetting live weather from " + controller.getUrlForCity("London") + ":\n");
		
		// loop control request call
		int max = 60;
		Scanner in = new Scanner(System.in);
		while(max > 0) {
			
			// ask user for input
			System.out.println("Input a city:");
			
			// execute request
			String response = in.nextLine();
			System.out.println(controller.getStringTest(response));
			
			// pause for 2 seconds between calls
			Thread.sleep(2000);
			max--;
		}
		in.close();
		System.out.println("Program shut down");
	}
}
