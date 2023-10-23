import exception.GlobalExceptionHandler;
import factory.BankFactory;
import factory.IBankFactory;
import models.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        // Factory Design Pattern :- Define an interface for creating an object,
        //                           but let subclasses decide which class to instantiate
        // or
        // Create object without exposing the creation logic to the client
        // and refer to newly created object using a common interface

        Scanner input=new Scanner(System.in);
        System.out.println("please, Enter your Card Number :");
        String cardNumber=input.next();
        String bankCode =cardNumber.substring(0,5);

        IBankFactory bankFactory=new BankFactory();
        Bank bank =bankFactory.getBank(bankCode); //bankCode is start with 12345 => banque misr OrElse banque du cairo
        System.out.println(bank.withdraw());
    }
}