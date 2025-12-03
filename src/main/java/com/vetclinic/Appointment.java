package com.vetclinic;

import com.google.inject.Inject;
import java.time.LocalDate;

/**
 * Клас Appointment (запис на прийом) має композицію з MedicalRecord.
 * Тепер він також залежить від MedicalRecordService для збереження запису у БД.
 */
public class Appointment {
    private LocalDate date;
    private Pet pet;
    private MedicalRecord record;
    private MedicalRecordService recordService;

    /**
     * Конструктор з впровадженням залежності від сервісу збереження даних.
     * @param recordService сервіс для збереження медичних записів
     */
    @Inject
    public Appointment(MedicalRecordService recordService) {
        this.recordService = recordService;
    }

    public void createAppointment(Pet pet, String diagnosis, String treatment) {
        this.date = LocalDate.now();
        this.pet = pet;
        this.record = new MedicalRecord(
            pet.getName(),
            diagnosis,
            treatment,
            date.toString()
        );

        System.out.println("📅 Прийом створено для " + pet.getName() + " (" + date + ")");
        
        // Збереження медичного запису в базу даних
        recordService.saveMedicalRecord(record);
    }

    public void displayInfo() {
        System.out.println("Appointment info:");
        System.out.println("Pet: " + pet.getName());
        System.out.println("Date: " + date);
    }
}
