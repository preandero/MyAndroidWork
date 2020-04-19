package com.lec.android.a008_practice;

public class MyPhonebook {

    String name;
    String age;
    String Address;

    public MyPhonebook() {
    }

    public MyPhonebook(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this. Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
