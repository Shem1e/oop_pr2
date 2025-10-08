public class Employee {
    private String name;
    private String position;
    private Task currentTask;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        System.out.println("Створено працівника: " + name);
    }

    public void assignTask(Task task) {
        this.currentTask = task;
        System.out.println("Працівнику " + name + " призначено завдання: " + task.getName());
    }

    public void showInfo() {
        System.out.println("Інформація про працівника:");
        System.out.println("Ім'я: " + name);
        System.out.println("Посада: " + position);
    }
}
