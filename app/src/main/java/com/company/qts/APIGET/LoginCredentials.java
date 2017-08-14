package com.company.qts.apiget;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 04/08/2017.
 */
public class LoginCredentials {
    @SerializedName("name")
    private String name;
    @SerializedName("pass")
    private String pass;

    public LoginCredentials(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
