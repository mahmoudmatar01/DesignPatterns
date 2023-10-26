# Template Method Design Pattern in Java

This repository contains Java code examples and explanations for the Template Method design pattern. The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm in a method, allowing subclasses to customize certain steps of the algorithm without changing its structure.

## Table of Contents

- [Introduction](#introduction)
- [Pattern Overview](#pattern-overview)
- [Getting Started](#getting-started)
- [Examples](#examples)


## Introduction

The Template Method design pattern is useful when you want to create an algorithm or process with defined steps, some of which can be customized by subclasses. This repository provides Java examples and explanations for implementing the Template Method pattern.

## Pattern Overview

In the Template Method pattern:

- An abstract class defines the overall algorithm structure using a template method.
- Concrete subclasses inherit from the abstract class and implement or override specific steps of the algorithm as needed.

This pattern is particularly beneficial when you have a common algorithm structure but want to allow for variation in certain steps.

## Getting Started

To get started with this repository, you can clone it to your local machine

## Examples

```java
// Abstract Base Class
public abstract class MakePizzaAlgorithm {

    private void bakePizza(){
        System.out.println("Baking Pizza");
    }

    abstract void definePizzaShape();

    private void putAddons(){
        System.out.println("Putting Pizza Addons");
    }

    private void heatPizza(){
        System.out.println("Heating Pizza");
    }

    public void makePizza(){
        bakePizza();
        definePizzaShape();
        putAddons();
        heatPizza();
    }
}

// Concrete subclasses
public class MakeRectanglePizza extends MakePizzaAlgorithm{
    @Override
    void definePizzaShape() {
        System.out.println("Making rectangle pizza");
    }
}
public class MakeRoundedPizza extends MakePizzaAlgorithm{
    @Override
    void definePizzaShape() {
        System.out.println("Making the pizza rounded");
    }
}

// client
public class Main {
    public static void main(String[] args) {

        MakePizzaAlgorithm rectanglePizza=new MakeRectanglePizza();
        rectanglePizza.makePizza();

        System.out.println("====================");
        MakePizzaAlgorithm roundedPizza=new MakeRoundedPizza();
        roundedPizza.makePizza();
    }
}

