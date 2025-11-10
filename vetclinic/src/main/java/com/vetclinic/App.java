package com.vetclinic;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
    public static void main(String[] args) {
        // 1️⃣ Створюємо injector і підключаємо модуль для SQLite
        Injector injector = Guice.createInjector(new VetclinicModule());

        // 2️⃣ Отримуємо об'єкт Appointment (Guice автоматично підставить залежності)
        Appointment appointment = injector.getInstance(Appointment.class);

        // 3️⃣ Створюємо Pet звичайним способом (це простий об’єкт, без залежностей)
        Pet pet = new Pet("Lyagushka", "Dog");

        // 4️⃣ Виконуємо логіку (створюємо прийом + збереження у базу)
        appointment.createAppointment(pet, "Allergy", "Antihistamine treatment");

        System.out.println("✅ Програма завершилася успішно.");
    }
}
