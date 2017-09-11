package com.company.qts.object;

/**
 * Created by MyPC on 11/09/2017.
 */
public class TraiCay {
    int img_animation;
    String tv_animation;

    public TraiCay() {
    }

    public TraiCay(int img_animation, String tv_animation) {
        this.img_animation = img_animation;
        this.tv_animation = tv_animation;
    }

    public int getImg_animation() {
        return img_animation;
    }

    public void setImg_animation(int img_animation) {
        this.img_animation = img_animation;
    }

    public String getTv_animation() {
        return tv_animation;
    }

    public void setTv_animation(String tv_animation) {
        this.tv_animation = tv_animation;
    }
}
