package com.company.qts.APIGET;

/**
 * Created by MyPC on 04/08/2017.
 */
public class ApiUtils {
    public static final String BASE_URL = "http://dev.2dev4u.com";

    private ApiUtils() {
    }

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
