package com.company.qts.apipost;

/**
 * Created by MyPC on 08/08/2017.
 */
public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://qtsvn.com/";

    public static ApiPost getApiPost() {

        return RetrofitClient.getClient(BASE_URL).create(ApiPost.class);
    }
}

