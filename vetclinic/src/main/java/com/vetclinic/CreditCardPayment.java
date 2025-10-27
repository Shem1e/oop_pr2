package com.vetclinic;

// Клас для обробки платежів кредитною карткою
public class CreditCardPayment implements IPayment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(float amount) {
        System.out.println("Обробка платежу на суму " + amount + " грн з карти " + cardNumber);
        return true;
    }

    public final String getReceipt() {
        return "Квитанція про оплату карткою " + cardNumber;
    }
}