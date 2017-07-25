package com.company.qts.Object;

/**
 * Created by MyPC on 25/07/2017.
 */
public class LineLVSetting {
    public String namesetting;
    public int imgarrowright;

    public LineLVSetting() {
    }

    public LineLVSetting(String namesetting, int imgarrowright) {
        this.namesetting = namesetting;
        this.imgarrowright = imgarrowright;
    }

    public LineLVSetting(String namesetting) {
        this.namesetting = namesetting;
    }

    public String getNamesetting() {
        return namesetting;
    }

    public void setNamesetting(String namesetting) {
        this.namesetting = namesetting;
    }

    public int getImgarrowright() {
        return imgarrowright;
    }

    public void setImgarrowright(int imgarrowright) {
        this.imgarrowright = imgarrowright;
    }
}
