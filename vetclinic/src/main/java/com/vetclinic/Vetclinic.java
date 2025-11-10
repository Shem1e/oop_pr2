package com.vetclinic;

import com.google.inject.Inject;
import java.time.LocalDate;

/**
 * Клас Vetclinic демонструє setter-based dependency injection:
 * залежність від MedicalRecordService впроваджується через set-метод.
 */
public class Vetclinic {
    private LocalDate date;
    private Pet pet;
    private MedicalRecord record;
    private MedicalRecordService recordService;

    public Vetclinic() {
        // порожній конструктор — тепер Guice використовує setter-інжекцію
    }

    /**
     * Setter-метод для впровадження залежності від MedicalRecordService.
     * Guice автоматично викличе цей метод при створенні об’єкта Vetclinic.
     */
    @Inject
    public void setMedicalRecordService(MedicalRecordService recordService) {
        this.recordService = recordService;
    }

    public void createRecord(Pet pet, String diagnosis, String treatment) {
        this.date = LocalDate.now();
        this.pet = pet;
        this.record = new MedicalRecord(
            pet.getName(),
            diagnosis,
            treatment,
            date.toString()
        );

        System.out.println("📅 Запис створено для " + pet.getName() + " (" + date + ")");

        // Виклик сервісу для збереження запису в базу
        recordService.saveMedicalRecord(record);
    }

    public void displayInfo() {
        System.out.println("Vetclinic appointment info:");
        System.out.println("Pet: " + pet.getName());
        System.out.println("Date: " + date);
    }
}
