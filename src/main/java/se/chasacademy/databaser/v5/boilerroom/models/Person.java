package se.chasacademy.databaser.v5.boilerroom.models;

public class Person {
    int personId;
    String name;
    String adress;
    int phoneNumber;



    public Person() {}


    public Person(int personId, String name, String address, int phoneNumber) {
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

    public int phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
