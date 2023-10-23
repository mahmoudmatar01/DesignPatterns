import exception.GlobalExceptionHandler;
import factory.BankFactory;
import factory.IBankFactory;
import models.Bank;
import models.Payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        // The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is an extension of the Factory Method pattern,
        // focusing on creating families of objects, ensuring that the created objects are compatible with each other.

        Scanner input=new Scanner(System.in);
        System.out.println("please, Enter your Card Number :");
        String cardNumber=input.next();
        String bankCode =cardNumber.substring(0,5);

        IBankFactory bankFactory=new BankFactory();
        Bank bank =bankFactory.getBank(bankCode); // if bankCode is start with 12345 => banque misr OrElse banque du cairo
        Payment payment= bankFactory.getPaymentCard(cardNumber);
        System.out.println(bank.withdraw());
        System.out.println(payment.getProviderInfo()); // if card number end with 1 => visa company orElse Mastercard

    }
}