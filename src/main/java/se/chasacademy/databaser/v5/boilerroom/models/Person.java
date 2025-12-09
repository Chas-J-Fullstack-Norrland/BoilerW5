package se.chasacademy.databaser.v5.boilerroom.models;

public class Person {
    int personId;
    String name;
    String adress;
    String phoneNumber;



    public Person() {}


    public Person(int personId, String name, String address, String phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.adress = address;
        this.phoneNumber = phoneNumber;
    }



    public int personId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

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

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
