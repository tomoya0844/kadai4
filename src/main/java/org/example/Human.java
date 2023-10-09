package org.example;

public class Human {
    private String name;
    private String country;
    private String sex;
    private int age;

    public Human(String name, String country, String sex, int age) {
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
