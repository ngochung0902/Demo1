package com.company.qts.hei;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 09/08/2017.
 */
public class PostHEIDrink {
    @SerializedName("drinks")
    @Expose
    private List<Drink> drinks = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PostHEIDrink{" +
                "drinks=" + drinks +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
