package com.vetclinic;

// Абстрактний клас, що представляє особу
public abstract class Person {
    private String name;
    private String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getContactInfo() {
        return "Ім'я: " + name + ", Телефон: " + phone;
    }
}