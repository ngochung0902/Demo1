package com.company.qts.object;

/**
 * Created by MyPC on 01/08/2017.
 */
public class Branchs {
    public int img_branchs;
    public String tv_to,tv_nho;

    public Branchs() {
    }

    public Branchs(int img_branchs, String tv_to, String tv_nho) {
        this.img_branchs = img_branchs;
        this.tv_to = tv_to;
        this.tv_nho = tv_nho;
    }

    public int getImg_branchs() {
        return img_branchs;
    }

    public void setImg_branchs(int img_branchs) {
        this.img_branchs = img_branchs;
    }

    public String getTv_to() {
        return tv_to;
    }

    public void setTv_to(String tv_to) {
        this.tv_to = tv_to;
    }

    public String getTv_nho() {
        return tv_nho;
    }

    public void setTv_nho(String tv_nho) {
        this.tv_nho = tv_nho;
    }
}
