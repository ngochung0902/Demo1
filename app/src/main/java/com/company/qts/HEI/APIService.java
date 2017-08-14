package com.company.qts.hei;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by MyPC on 08/08/2017.
 */
public interface APIService {
//
    @POST("HEI/webservices/login.php")
    @FormUrlEncoded
    Call<PostHEI> savePost(@Field("email") String email,
                           @Field("password") String password,
                           @Field("app_id") String app_id);
//--------------------------------------------------------------------------------------------------
    @POST("HEI/app/webroot/webservices/get_spirit.php")
    @FormUrlEncoded
    Call<PostSpirits> postSpirits(@Field("app_id") String app_id);
//--------------------------------------------------------------------------------------------------
    @POST("HEI/app/webroot/webservices/get_drink_by_spirit.php")
    @FormUrlEncoded
    Call<PostHEIDrink> postHEIDrink(@Field("app_id") String app_id,
                                    @Field("spirit_id") String spirit_id);
//--------------------------------------------------------------------------------------------------
    @POST("HEI/app/webroot/webservices/get_mix.php")
    @FormUrlEncoded
    Call<PostMixologist> postMixilogist(@Field("app_id") String app_id,
                                        @Field("spirit_id") String spirit_id,
                                        @Field("mixologist_id")String mixologist_id);
}
