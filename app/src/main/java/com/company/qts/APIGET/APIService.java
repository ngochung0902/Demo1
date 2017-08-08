package com.company.qts.APIGET;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 04/08/2017.
 */
public interface APIService {
    @GET("/news/api.php?latest_news=10")
    Call<List<Post>> getPostsDetails();

    // GET news by id post from server
    // Server return json object
    @GET("/news/api.php?id_post=2")
    Call<Post> getPostDetails();

//    @FormUrlEncoded
//    @POST("/login")
//    void login(@Field("email") String email, @Field("password")String password, Callback<BaseMO> callback);

//    @POST("/login")
//    Call<String> loginWithCredentials(@Body LoginCredentials data);

//    @POST("api/{email}/{password}")
//    Call<Login> registration(@Path("email") String email, @Path("password") String password);
//
//    @GET("api/{email}/{password}")
//    Call<Login> authenticate(@Path("email") String email, @Path("password") String password);


}
