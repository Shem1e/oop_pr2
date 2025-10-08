public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск імітаційного прототипу");
        
        // Створення екземплярів класів
        Employee employee = new Employee("Іван Петренко", "Розробник");
        Task task = new Task("Розробка нової функції", "Висока");
        Project project = new Project("Проєкт X", "В розробці");
        
        // Імітація роботи з об'єктами
        employee.assignTask(task);
        project.addTask(task);
        
        // Демонстрація роботи
        employee.showInfo();
        task.showStatus();
        project.showProgress();
    }
}
