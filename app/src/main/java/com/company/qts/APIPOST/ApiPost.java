package com.company.qts.apipost;

import com.company.qts.apiget.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiPost {

//    @GET("api/{email}/{password}/{app_id}")
//    Call<Login> authenticate(@Path("email") String email, @Path("password") String password, @Path("app_id") String app_id);
//
//    @POST("api/{email}/{password}/{app_id}")
//    Call<Post> registration(@Path("email") String email, @Path("password") String password, @Path("app_id") String app_id);

    @POST("HEI/webservices/login.php")
    @FormUrlEncoded
    Call<PostAPI> savePost(@Field("email") String email,
                        @Field("password") String password,
                        @Field("app_id") String app_id);

    // RxJava
   /* @POST("/posts")
    @FormUrlEncoded
    Observable<Post> savePost(@Field("title") String title,
                              @Field("body") String body,
                              @Field("userId") long userId);*/

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") long id);
}