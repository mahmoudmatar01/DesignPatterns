# Strategy Design Pattern in Java

This repository contains Java code examples and explanations for the Strategy design pattern. The Strategy pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows you to select an algorithm's behavior at runtime.

## Table of Contents

- [Introduction](#introduction)
- [Pattern Overview](#pattern-overview)
- [Getting Started](#getting-started)
- [Examples](#examples)


## Introduction

The Strategy design pattern is useful when you want to define a set of algorithms, encapsulate each one, and make them interchangeable. This repository provides Java examples and explanations for implementing the Strategy pattern.

## Pattern Overview

In the Strategy pattern:

- You define a family of algorithms, encapsulate each one in a separate class (strategy), and make them interchangeable.
- A context class delegates the algorithm to a concrete strategy, allowing you to switch between strategies at runtime.

This pattern promotes flexibility and allows you to avoid a fixed implementation in your code.

## Getting Started

To get started with this repository, you can clone it to your local machine

## Examples

```java

// family of algorithms
public interface CarAlgorithm {
    void performAlgorithm();
}

public class Chevorlet implements CarAlgorithm {
    @Override
    public void performAlgorithm() {
        System.out.println("Perform Chev Disassembly Algorithm ");
    }
}

public class Toyota implements CarAlgorithm{
    @Override
    public void performAlgorithm() {
        System.out.println("Perform Toyota Disassembly Algorithm ");
    }
}

// context class
public class Mechanic {

    private CarAlgorithm carAlgorithm=null;

    public void setCarAlgorithm(CarAlgorithm carAlgorithm) {
        this.carAlgorithm = carAlgorithm;
    }

    public void disassembleCar(){
        carAlgorithm.performAlgorithm();
    }
}

// client
public class Main {
    public static void main(String[] args) {

        var belya =new Mechanic();
        System.out.println("Toyota Car Entered Garage ");
        belya.setCarAlgorithm(new Toyota());
        belya.disassembleCar();

        System.out.println("=========after 5 min======================");

        System.out.println("Chev Car Entered Garage");
        belya.setCarAlgorithm(new Chevorlet());
        belya.disassembleCar();

        // Programming Scenario
        //       - Games
        //       - Sorting

    }
}
