package com.company.qts.HEI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 08/08/2017.
 */
public class PostSpirits {
    @SerializedName("spirits")
    @Expose
    private List<Spirit> spirits = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<Spirit> getSpirits() {
        return spirits;
    }

    public void setSpirits(List<Spirit> spirits) {
        this.spirits = spirits;
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
        return "PostSpirits{" +
                "spirits=" + spirits +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}

