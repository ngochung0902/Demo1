package com.company.qts.Object;

/**
 * Created by MyPC on 31/07/2017.
 */
public class Level {
    public Integer img_level;
    public String tv_level;

    public Level(Integer img_level, String tv_level) {
        this.img_level = img_level;
        this.tv_level = tv_level;
    }

    public Level() {
    }

    public Integer getImg_level() {
        return img_level;
    }

    public void setImg_level(Integer img_level) {
        this.img_level = img_level;
    }

    public String getTv_level() {
        return tv_level;
    }

    public void setTv_level(String tv_level) {
        this.tv_level = tv_level;
    }
}
