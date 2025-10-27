package com.vetclinic;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private String status;
    private List<Task> tasks;

    public Project(String name, String status) {
        this.name = name;
        this.status = status;
        this.tasks = new ArrayList<>();
        System.out.println("Створено проєкт: " + name);
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("До проєкту " + name + " додано нове завдання");
    }

    public void showProgress() {
        System.out.println("Прогрес проєкту " + name + ":");
        System.out.println("Статус: " + status);
        System.out.println("Кількість завдань: " + tasks.size());
    }
}
