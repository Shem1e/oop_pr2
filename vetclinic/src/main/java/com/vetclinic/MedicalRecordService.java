package com.vetclinic;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Сервіс для збереження медичних записів у базу даних.
 * Залежність від Connection впроваджується через Google Guice.
 */
public class MedicalRecordService {

    private final Connection connection;

    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних SQLite
     */
    @Inject
    public MedicalRecordService(Connection connection) {
        this.connection = connection;
    }

    /**
     * Метод для збереження об'єкта MedicalRecord у таблицю medical_records.
     */
    public void saveMedicalRecord(MedicalRecord record) {
        String sql = "INSERT INTO medical_records (pet_name, diagnosis, treatment, date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, record.getPetName());
            statement.setString(2, record.getDiagnosis());
            statement.setString(3, record.getTreatment());
            statement.setString(4, record.getDate());
            statement.executeUpdate();
            System.out.println("✅ Медичний запис успішно збережено у базу даних!");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Помилка при збереженні медичного запису", e);
        }
    }
}
