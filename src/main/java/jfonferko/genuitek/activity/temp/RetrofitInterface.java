package jfonferko.genuitek.activity.temp;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JFonferko on 2016-08-26.
 */
public interface RetrofitInterface {

    @GET("wiadomosci/kraj/wyciekly-dane-z-systemu-pesel/zyt9tk")
    Call <ResponseBody>getOnet();

    @GET("users/{login}")
    Call<ResponseBody> getGitHubUser(@Path("login") String login);

}