package com.vetclinic;

// Клас, що представляє ветеринара
public class Veterinarian extends Person {
    private String specialty;
    
    public Veterinarian(String name, String phone, String specialty) {
        super(name, phone);
        this.specialty = specialty;
    }
    
    public void examine(Pet pet) {
        System.out.println("Огляд тварини " + pet.getName() + " (" + pet.getSpecies() + ")");
    }
    
    public void vaccinate(Pet pet) {
        System.out.println("Вакцинація тварини " + pet.getName());
    }
    
    public void sendAnalysis(Pet pet, Laboratory lab) {
        System.out.println("Відправлено аналізи тварини " + pet.getName() + " до лабораторії");
        lab.receiveAnalysis(pet);
    }
}