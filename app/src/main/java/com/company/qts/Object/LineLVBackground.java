package com.company.qts.Object;

/**
 * Created by MyPC on 26/07/2017.
 */
public class LineLVBackground {
    public int img_check,img_colorview;
    public String namecolor;

    public LineLVBackground() {
    }

    public LineLVBackground(int img_check, String namecolor, int img_colorview) {
        this.img_check = img_check;
        this.namecolor = namecolor;
        this.img_colorview = img_colorview;
    }

    public LineLVBackground(int img_check) {
        this.img_check = img_check;
    }

    public LineLVBackground(String namecolor, int img_colorview) {
        this.namecolor = namecolor;
        this.img_colorview = img_colorview;
    }

    public int getImg_check() {
        return img_check;
    }

    public void setImg_check(int img_check) {
        this.img_check = img_check;
    }

    public String getNamecolor() {
        return namecolor;
    }

    public void setNamecolor(String namecolor) {
        this.namecolor = namecolor;
    }

    public int getImg_colorview() {
        return img_colorview;
    }

    public void setImg_colorview(int img_colorview) {
        this.img_colorview = img_colorview;
    }
}
