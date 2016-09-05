package jfonferko.genuitek.activity.temp;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by JFonferko on 2016-08-26.
 */
public class OkHttpJfoClient {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	OkHttpClient okHttpClient = new OkHttpClient();

	String post(String url, String json) throws IOException {
		RequestBody requestBody = RequestBody.create(JSON, json);
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();

		Response response = okHttpClient.newCall(request).execute();
		return response.body().toString();

	}
}