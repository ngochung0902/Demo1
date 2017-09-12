package com.company.qts.englishgrammar.activity;

/**
 * Created by tuanlq on 7/26/2016.
 */
public class LessionModel {
    public int id;
    public int img;
    public String lessionName;

    public LessionModel(int id, String name)
    {
        this.id = id;
        this.lessionName = name;
    }

    public LessionModel(int id, int img, String lessionName) {
        this.id = id;
        this.img = img;
        this.lessionName = lessionName;
    }
}
