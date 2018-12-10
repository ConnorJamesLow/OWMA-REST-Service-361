/**
 * Connor Low
 * CST-
 * Oct 18, 2018
 * Source: http://square.github.io/okhttp/
 */
package api.controller;

import java.io.IOException;

import com.google.gson.Gson;
import api.models.PiData;
import api.models.RestResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author speed
 *
 */
public class BrendansRoomTemperatureController {
	private static final String TARGET_URL = "http://localhost:8080/361_CLC/rest/iot/save";

	/**
	 * POST PiData to the reporting app
	 * 
	 * @param model
	 * @return
	 */
	public static int send(PiData model) {
		try {

			// Create client
			OkHttpClient client = new OkHttpClient();

			// make a json payload
			Gson gson = new Gson();
			String json = gson.toJson(model);
			System.out.println(json);

			// create a request body
			RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
			System.out.println(json);

			// create request
			Request request = new Request.Builder().url(TARGET_URL).post(body).build();

			// send request
			Response response = client.newCall(request).execute();

			// print result
			RestResponse<PiData> rr = gson.fromJson(response.body().charStream(), new RestResponse<PiData>().getClass());
			
			return rr.getStatus();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
