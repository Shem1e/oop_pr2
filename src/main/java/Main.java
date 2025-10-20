// Головний клас для демонстрації роботи програми
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Owner owner = new Owner("Іван Петренко", "+380991234567");
        Veterinarian vet = new Veterinarian("Марія Коваленко", "+380671234567", "Терапевт");
        Laboratory lab = new Laboratory("МедЛаб");
        Pet pet = new Pet("Барсик", "Кіт");
        CreditCardPayment payment = new CreditCardPayment("4149-1234-5678-9012");

        // Демонстрація роботи
        System.out.println("=== Демонстрація роботи програми ===\n");
        
        // Запис на вакцинацію
        owner.bookVaccination(pet, vet);
        
        // Огляд та вакцинація
        vet.examine(pet);
        vet.vaccinate(pet);
        
        // Відправка аналізів
        vet.sendAnalysis(pet, lab);
        
        // Публікація результатів
        String results = lab.publishResults(pet);
        System.out.println(results);
        
        // Оплата послуг
        owner.payForService(payment);
        System.out.println(payment.getReceipt());
    }
}
