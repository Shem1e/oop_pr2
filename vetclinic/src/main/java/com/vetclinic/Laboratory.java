package com.vetclinic;

// Клас, що представляє лабораторію
public class Laboratory {
    private String labName;
    
    public Laboratory(String name) {
        this.labName = name;
    }
    
    public String publishResults(Pet pet) {
        return "Результати аналізів для " + pet.getName() + " готові";
    }
    
    public void receiveAnalysis(Pet pet) {
        System.out.println("Лабораторія " + labName + " отримала аналізи для " + pet.getName());
    }
}