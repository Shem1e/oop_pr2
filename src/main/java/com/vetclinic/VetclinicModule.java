package com.vetclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * VetclinicModule — модуль Google Guice для роботи з базою даних SQLite.
 * Підключається до файлу vetclinic.db у папці target/
 * та створює таблицю medical_records для збереження медичних карток.
 */
public class VetclinicModule extends AbstractModule {

    @Override
    protected void configure() {
        // Прив'язка JDBC URL до SQLite бази
        bind(String.class)
            .annotatedWith(Names.named("JDBC URL"))
            .toInstance("jdbc:sqlite:target/vetclinic.db");
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    private void createTableIfNotExists(Connection connection) {
        String createTableSQL =
        "CREATE TABLE IF NOT EXISTS medical_records (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "pet_name TEXT NOT NULL, " +
        "diagnosis TEXT NOT NULL, " +
        "treatment TEXT NOT NULL, " +
        "date TEXT NOT NULL" +
        ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}
