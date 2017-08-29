package com.company.qts.object;

/**
 * Created by MyPC on 29/08/2017.
 */
public class Football {
    public int ID;
    public String image,name,club,age;

    public Football() {
    }

    public Football(int ID, String image, String name, String club, String age) {
        this.ID = ID;
        this.image = image;
        this.name = name;
        this.club = club;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
