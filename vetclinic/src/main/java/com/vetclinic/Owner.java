package com.vetclinic;

import java.util.ArrayList;
import java.util.List;

// Клас, що представляє власника тварини
public class Owner extends Person {
    private List<Pet> pets;

    public Owner(String name, String phone) {
        super(name, phone);
        this.pets = new ArrayList<>();
    }

    public void bookVaccination(Pet pet, Veterinarian vet) {
        System.out.println("Записано на вакцинацію до ветеринара: " + vet.getContactInfo());
    }

    public void payForService(IPayment payment) {
        payment.processPayment(500.0f);
    }
}