package com.company.qts.object;

/**
 * Created by MyPC on 06/09/2017.
 */
public class Products {
    int img;
    String textn,textl;

    public Products(int img, String textn, String textl) {
        this.img = img;
        this.textn = textn;
        this.textl = textl;
    }

    public Products() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTextn() {
        return textn;
    }

    public void setTextn(String textn) {
        this.textn = textn;
    }

    public String getTextl() {
        return textl;
    }

    public void setTextl(String textl) {
        this.textl = textl;
    }
}
