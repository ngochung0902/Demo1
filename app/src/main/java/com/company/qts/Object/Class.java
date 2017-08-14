package com.company.qts.object;

/**
 * Created by MyPC on 31/07/2017.
 */
public class Class {
    public Integer img_class;
    public String tv_class;

    public Class(Integer img_class, String tv_class) {
        this.img_class = img_class;
        this.tv_class = tv_class;
    }

    public Class() {
    }

    public Integer getImg_class() {
        return img_class;
    }

    public void setImg_class(Integer img_class) {
        this.img_class = img_class;
    }

    public String getTv_class() {
        return tv_class;
    }

    public void setTv_class(String tv_class) {
        this.tv_class = tv_class;
    }
}
