# Observer Design Pattern in Java

This repository contains Java code examples and explanations for the Observer design pattern. The Observer pattern is a behavioral design pattern that defines a one-to-many relationship between objects so that when one object changes its state, all its dependents are notified and updated automatically.

## Table of Contents

- [Introduction](#introduction)
- [Pattern Overview](#pattern-overview)
- [Getting Started](#getting-started)
- [Examples](#examples)

## Introduction

The Observer design pattern is useful when you need to maintain a one-to-many relationship between objects, ensuring that changes in one object are reflected in its dependents. This repository provides Java examples and explanations for implementing the Observer pattern.

## Pattern Overview

In the Observer pattern:

- There is a subject (or publisher) that maintains a list of observers (or subscribers).
- Observers register with the subject to receive updates.
- When the subject's state changes, it notifies all its observers, triggering updates in their state or behavior.

This pattern allows for loose coupling between subjects and observers, enabling a change in one part of the system without affecting others.

## Getting Started

To get started with this repository, you can clone it to your local machine

## Examples

```java
// Subject class
public interface Subject {
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void sendNotification();
}

// concrete subject class
public class Product implements Subject {
    private String name;
    private String availablity;
    private List<Observer>observerList;

    public Product(String name){
        this.name=name;
        observerList=new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
        System.out.println("observer "+name+" has been added");
    }

    @Override
    public void unSubscribe(Observer observer) {
        observerList.remove(observer);
        System.out.println("observer "+name+" has been removed");
    }

    @Override
    public void sendNotification() {
        for (Observer observer:observerList){
            observer.listen(availablity);
        }
    }

    public void setAvailablity(boolean availablity) {
        this.availablity =this.name+(availablity?" Available":" Not available");
        sendNotification();
    }
}

// Observer class
public interface Observer {
    void listen(String message);
}


//concrete observer class
public class Person implements Observer{

    private String name;
    public Person(String name){
        this.name=name;
    }

    @Override
    public void listen(String message) {
        System.out.println(name+" Got new notification : "+message);
    }
}


//client
public class Main {
    public static void main(String[] args) {

        Product iPhone=new Product("iphone 11 pro max");
        Person mahmoud=new Person("Mahmoud");
        Person ahmed=new Person("Ahmed");
        Person mustafa=new Person("Mustafa");

        iPhone.subscribe(mahmoud);
        iPhone.subscribe(ahmed);
        System.out.println("============================");
        iPhone.setAvailablity(true);
        System.out.println("============================");
        iPhone.setAvailablity(false);
        System.out.println("============================");
        iPhone.unSubscribe(ahmed);
        iPhone.unSubscribe(mahmoud);
        System.out.println("============================");
        iPhone.subscribe(mustafa);
        iPhone.setAvailablity(true);

    }
}

