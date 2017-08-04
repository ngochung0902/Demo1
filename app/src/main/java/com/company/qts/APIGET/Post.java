package com.company.qts.APIGET;

/**
 * Created by MyPC on 04/08/2017.
 */
public class Post {
    int id_post;
    int id_ca;
    String name_ca;
    String title;
    String description;
    String content;
    String datetime;
    String image;

    public int getId_post() {
        return id_post;
    }

    public int getId_ca() {
        return id_ca;
    }

    public String getName_ca() {
        return name_ca;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return (title);
    }
}
