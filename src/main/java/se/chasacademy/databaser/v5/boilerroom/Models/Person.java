package se.chasacademy.databaser.v5.boilerroom.Models;

public class Person {

    String name;
    String adress;
    int phoneNumber;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String adress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
