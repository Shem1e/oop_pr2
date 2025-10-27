package com.vetclinic;

// Інтерфейс для обробки платежів
public interface IPayment {
    boolean processPayment(float amount);
}