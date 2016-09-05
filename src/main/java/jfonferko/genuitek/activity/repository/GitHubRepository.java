package jfonferko.genuitek.activity.repository;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.GsonBuilder;
import jfonferko.genuitek.activity.model.GitHubUser;
import jfonferko.genuitek.activity.temp.RetrofitInterface;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JFonferko on 2016-08-29.
 */
public class GitHubRepository {

	private final static String gitHubUrl = "http:/api.github.com/";

	private final static Retrofit retrofit = new Retrofit.Builder()
			.addConverterFactory(
					GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
			.baseUrl(gitHubUrl).build();

    private static RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

	private ResponseBody getGitHubUserData(String username) throws IOException {
		ResponseBody response = retrofitInterface.getGitHubUser(username).execute().body();
        return response;
	}

	public GitHubUser getGitHubUserByLogin(String username) {
		ObjectMapper mapper = new ObjectMapper();

		GitHubUser gitHubUser = null;
		try {
			gitHubUser = mapper.readValue(getGitHubUserData(username).string(), GitHubUser.class);
		} catch (Exception e) {
			System.out.println("Can't find user with login = "+username);
		}
		return gitHubUser;
	}
}