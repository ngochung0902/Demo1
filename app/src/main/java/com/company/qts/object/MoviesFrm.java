package com.company.qts.object;

/**
 * Created by MyPC on 17/08/2017.
 */
public class MoviesFrm {
    int img_movies;
    String tv_namemovies,tv_day,tv_year;

    public MoviesFrm() {
    }

    public MoviesFrm(int img_movies, String tv_namemovies, String tv_day, String tv_year) {
        this.img_movies = img_movies;
        this.tv_namemovies = tv_namemovies;
        this.tv_day = tv_day;
        this.tv_year = tv_year;
    }

    public int getImg_movies() {
        return img_movies;
    }

    public void setImg_movies(int img_movies) {
        this.img_movies = img_movies;
    }

    public String getTv_namemovies() {
        return tv_namemovies;
    }

    public void setTv_namemovies(String tv_namemovies) {
        this.tv_namemovies = tv_namemovies;
    }

    public String getTv_day() {
        return tv_day;
    }

    public void setTv_day(String tv_day) {
        this.tv_day = tv_day;
    }

    public String getTv_year() {
        return tv_year;
    }

    public void setTv_year(String tv_year) {
        this.tv_year = tv_year;
    }
}
