package com.company.qts.object;

/**
 * Created by MyPC on 28/07/2017.
 */
public class LineGv {
    int img_flowerr;
    String name;

    public LineGv(int img_flowerr, String name) {
        this.img_flowerr = img_flowerr;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LineGv(int img_flowerr) {
        this.img_flowerr = img_flowerr;
    }

    public LineGv() {
    }

    public int getImg_flowerr() {
        return img_flowerr;
    }

    public void setImg_flowerr(int img_flowerr) {
        this.img_flowerr = img_flowerr;
    }
}
