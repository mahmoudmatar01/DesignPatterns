# Decorator Design Pattern

This repository contains an implementation of the Decorator Design Pattern in [programming language of your choice]. The Decorator Design Pattern is a structural pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

## Table of Contents

- [Decorator Design Pattern Overview](#decorator-design-pattern-overview)
- [How to Use](#how-to-use)
- [Examples](#examples)


## Decorator Design Pattern Overview

The Decorator Design Pattern is used to extend the functionality of objects without modifying their class. It is achieved by creating a set of decorator classes that are used to wrap concrete components. Decorators provide additional functionality by recursively calling the methods of the wrapped object. Key points about the Decorator Design Pattern:

- It allows for adding responsibilities to objects dynamically.
- Decorators are often used to extend the behavior of classes when you can't subclass them, or when you want to avoid a proliferation of subclasses.

## How to Use

Provide instructions on how to use the Decorator Design Pattern in your code. Explain how to create and work with decorators, and any specific usage details.

```[Include code examples or usage instructions here]```

## Examples

You can find examples of how to use the Decorator Design Pattern in the [examples](/examples) directory. Each example showcases how decorators can be used to extend the functionality of a base component.

```java
public interface Sandwich {

     double getCost();
    String getDescription();
}

public class BasicSandwich implements Sandwich {
    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "it consists from only bread";
    }
}

public abstract class SandwichDecorator implements Sandwich {

    private Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public double getCost() {
        return sandwich.getCost();
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription();
    }
}

public class CheeseSandwich extends SandwichDecorator {
    public CheeseSandwich(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public double getCost() {
        return super.getCost()+5;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" and cheese";
    }
}

public class MeetSandwich extends SandwichDecorator {
    public MeetSandwich(Sandwich sandwich) {
        super(sandwich);
    }
    @Override
    public double getCost() {
        return super.getCost()+20;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+",cheese and meet";
    }
}

public class Main {
    public static void main(String[] args) {

        Sandwich meetSandwich=new MeetSandwich(new BasicSandwich());
        Sandwich cheeseSandwich=new CheeseSandwich(new BasicSandwich());
        Sandwich basicSandwich=new BasicSandwich();

        System.out.println("=========== Basic sandwich info ==================");
        System.out.println(basicSandwich.getDescription());
        System.out.println(basicSandwich.getCost());

        System.out.println("=========== Meet sandwich info ==================");
        System.out.println(meetSandwich.getDescription());
        System.out.println(meetSandwich.getCost());

        System.out.println("=========== Cheese sandwich info ==================");
        System.out.println(cheeseSandwich.getDescription());
        System.out.println(cheeseSandwich.getCost());

        }
}


