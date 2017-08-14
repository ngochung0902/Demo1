package com.company.qts.apipost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 07/08/2017.
 */
public class PostAPI {
        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("success")
        @Expose
        private Integer success;
        @SerializedName("message")
        @Expose
        private String message;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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
        return "Post{" +
                "user=" + user +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }

}
