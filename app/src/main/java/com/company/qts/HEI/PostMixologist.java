package com.company.qts.hei;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 09/08/2017.
 */
public class PostMixologist {
    @SerializedName("mixologists")
    @Expose
    private List<Mixologist> mixologists = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<Mixologist> getMixologists() {
        return mixologists;
    }

    public void setMixologists(List<Mixologist> mixologists) {
        this.mixologists = mixologists;
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
        return "PostMixologist{" +
                "mixologists=" + mixologists +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
