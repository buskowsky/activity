package jfonferko.genuitek.activity.temp;

import java.io.IOException;

import jfonferko.genuitek.activity.model.GitHubUser;
import jfonferko.genuitek.activity.repository.GitHubRepository;
import okhttp3.*;

/**
 * Created by JFonferko on 2016-08-26.
 */
public class ClientRun {

	public static void main(String[] args) throws IOException {

		// OkHttpJfoClient okHttpJfoClient = new OkHttpJfoClient();
		// okHttpJfoClient.post("http://www.onet.pl", "json");

		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url("http://www.github.com").build();

		okHttpClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				//System.out.println(response.body().string());
			}
		});
		System.out.println("jfo");
		System.out.println("---------------------------------------");

//		Retrofit retrofit = new Retrofit.Builder()
//				.addConverterFactory(GsonConverterFactory.create(
//						new GsonBuilder().setLenient().create()))
//				.baseUrl("http:/api.github.com/").build();
//        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
//        //System.out.println(retrofitInterface.getGitHub().execute().body().string());
//		ResponseBody response = retrofitInterface.getGitHubUser("krzysztof").execute().body();
//
//		//System.out.println(response.string());
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		/**
//		 * Read object from responseBody
//		 */
//		GitHubUser gitHubUser = null;
//		try {
//			gitHubUser = mapper.readValue(response.string(), GitHubUser.class);
//		} catch (Exception e) {
//			System.out.println();
//		}

		GitHubRepository gitHubRepository = new GitHubRepository();
		GitHubUser gitHubUser = gitHubRepository.getGitHubUserByLogin("paweł");

		try {
			System.out.println(gitHubUser.getLogin());
			System.out.println(gitHubUser.getEmail());
			System.out.println(gitHubUser.getId());
			System.out.println(gitHubUser.getLocation());
			System.out.println(gitHubUser.getName());
			System.out.println(gitHubUser.getPublicRepos());
			System.out.println(gitHubUser.getReposUrl());
		}catch(NullPointerException npe ){
			System.out.println("Some problem");
		}
	}
}