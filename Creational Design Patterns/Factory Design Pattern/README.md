# Factory Design Pattern

## Overview

The Factory Design Pattern is a creational design pattern that provides an interface for creating objects in a super class but allows subclasses to alter the type of objects that will be created. It promotes loose coupling and simplifies object creation, making it a widely used pattern in various software applications.

## Motivation

The Factory Design Pattern is used to address the following concerns:

1. **Object Creation**: It separates object creation from its usage, ensuring that object creation is handled in a centralized manner.

2. **Abstraction**: It promotes the use of abstract types or interfaces, allowing for flexibility and future extensibility.

3. **Decoupling**: It minimizes dependencies by abstracting the client code from the concrete class.

## Implementation

The Factory Design Pattern typically consists of the following components:

- **Creator (Factory)**: An interface or an abstract class defining the factory methods to create objects. This is the part that clients interact with.

- **Concrete Creator**: Subclasses that implement the factory methods defined in the Creator, responsible for creating specific objects.

- **Product**: An interface or an abstract class representing the objects that the Factory can create.

- **Concrete Product**: Classes that implement the Product interface, representing specific objects created by the Factory.

## Usage

To use the Factory Design Pattern, follow these steps:

1. Create a Factory class that provides factory methods to create objects of a specific type.

2. Define an interface or abstract class for the products to be created.

3. Create concrete classes that implement the product interface.

4. Use the Factory class to create objects without needing to know the specific class of the object being created.

## Example

Consider a simple example of a Factory pattern that creates different types of Banks (e.g., Banque Misr, Banque du Cairo):

```java
// Abstract Bank Class
public abstract class Bank {

   public abstract String withdraw();
}


// Concrete implementations
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


// Interface Factory
public interface IBankFactory {
     Bank getBank(String bankCode);
}


// Bank Factory
public class BankFactory implements IBankFactory{
    @Override
    public Bank getBank(String bankCode) {
        return switch (bankCode) {
            case "12345" -> new BanqueMisr();
            case "11111" -> new BanqueDuCairo();
            default -> null;
        };
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
        Bank bank =bankFactory.getBank(bankCode); //bankCode is start with 12345 => banque misr OrElse banque du cairo
        System.out.println(bank.withdraw());
    }
}
