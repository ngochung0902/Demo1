package com.company.qts.object;

/**
 * Created by MyPC on 03/08/2017.
 */
public class Contacts {
    public int Id;
    public String fistname,lastname,birthday,number;

    public Contacts() {
    }

    public Contacts(int id, String fistname, String lastname, String number, String birthday) {
        Id = id;
        this.fistname = fistname;
        this.lastname = lastname;
        this.number = number;
        this.birthday = birthday;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
