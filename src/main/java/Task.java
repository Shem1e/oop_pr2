public class Task {
    private String name;
    private String priority;
    private String status;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.status = "Нове";
        System.out.println("Створено завдання: " + name);
    }

    public String getName() {
        return name;
    }

    public void showStatus() {
        System.out.println("Статус завдання " + name + ": " + status);
        System.out.println("Пріоритет: " + priority);
    }
}
