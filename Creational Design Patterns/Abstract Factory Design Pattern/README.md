# Abstract Factory Design Pattern

## Overview

The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is an extension of the Factory Method pattern, focusing on creating families of objects, ensuring that the created objects are compatible with each other.

## Motivation

The Abstract Factory Design Pattern is used to address the following concerns:

1. **Object Creation**: It separates object creation from its usage, allowing the creation of multiple related objects consistently.

2. **Encapsulation**: It encapsulates the creation logic, making it easier to change the object creation process or introduce new product families without affecting the client code.

3. **Dependency Management**: It promotes loose coupling by ensuring that client code interacts with abstract interfaces rather than concrete classes.

## Implementation

The Abstract Factory Design Pattern typically consists of the following components:

- **Abstract Factory**: An interface or an abstract class defining a set of factory methods for creating a family of related objects.

- **Concrete Factory**: Subclasses that implement the factory methods defined in the Abstract Factory, responsible for creating specific families of objects.

- **Abstract Product**: Interfaces or abstract classes representing the products within a family. Each product can have multiple implementations.

- **Concrete Product**: Classes that implement the Abstract Product interfaces or extend abstract classes, representing specific objects created by the factory.

## Usage

To use the Abstract Factory Design Pattern, follow these steps:

1. Create an Abstract Factory interface or abstract class that defines factory methods to create related objects.

2. Define Abstract Product interfaces or abstract classes for each type of product within the families.

3. Create concrete factories by implementing the Abstract Factory, specifying how to create products for a specific family.

4. Create concrete product classes that implement the Abstract Product interfaces or extend abstract classes.

5. Use the concrete factory to create objects within a specific family, ensuring that these objects are compatible with each other.

## Example

Consider a simple example of an Abstract Factory pattern that creates different types of furniture (e.g., Modern Furniture and Victorian Furniture):

```java
// Abstract Bank Factory
public interface IBankFactory {
     Bank getBank(String bankCode);

     Payment getPaymentCard(String cardNumber);
}
public class BankFactory implements IBankFactory{
    @Override
    public Bank getBank(String bankCode) {
        return switch (bankCode) {
            case "12345" -> new BanqueMisr();
            case "11111" -> new BanqueDuCairo();
            default -> null;
        };
    }

    @Override
    public Payment getPaymentCard(String cardNumber) {
        return switch (cardNumber.charAt(cardNumber.length()-1)) {
            case '1' -> new Visa();
            case '2' -> new MasterCard();
            default -> null;
        };
    }
}


// Abstract Bank and Payment Models
public abstract class Bank {
   public abstract String withdraw();
}

public abstract class Payment {
    public abstract String getName();
    public abstract String getProviderInfo();
}


// Concrete Bank Classes
public class BanqueDuCairo extends Bank {
    @Override
   public String withdraw() {
        return "Your Request is handling by banque du cairo";
    }
}

public class BanqueMisr extends Bank {
    @Override
   public String withdraw() {
        return "Your Request is handling by banque misr";
    }
}


// Concrete Payment Method Classes
public class MasterCard extends Payment{
    @Override
    public String getName() {
        return "MasterCard";
    }

    @Override
    public String getProviderInfo() {
        return "MasterCard Company";
    }
}
public class Visa extends Payment{
    @Override
    public String getName() {
        return "Visa Card";
    }

    @Override
    public String getProviderInfo() {
        return "Visa Company";
    }
}

// client implementation

public class Main {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
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
