# Chain of Responsibility Design Pattern in Java

This repository contains Java code examples and explanations for the Chain of Responsibility design pattern. The Chain of Responsibility pattern is a behavioral design pattern that allows you to pass requests along a chain of handlers. Each handler decides whether to process the request or pass it to the next handler in the chain.

## Table of Contents

- [Introduction](#introduction)
- [Pattern Overview](#pattern-overview)
- [Getting Started](#getting-started)
- [Examples](#examples)


## Introduction

The Chain of Responsibility pattern promotes loose coupling in software design and simplifies object handling. It is especially useful when you want to decouple the sender and receiver of a request. This repository provides Java examples and explanations for the Chain of Responsibility design pattern.

## Pattern Overview

In the Chain of Responsibility pattern:

- There is a chain of handlers, each having a specific responsibility.
- A request is passed along the chain until it is handled or until it reaches the end of the chain.

This pattern allows you to dynamically configure the chain and add or remove handlers without affecting the client code.

## Getting Started

To get started with this repository, you can clone it to your local machine

## Examples

```java
// Base Handler
public abstract class Handler {
    public Handler successor=null;
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public abstract void handleRequest(Request request);
}

// concretes
public class CEO extends Handler{
    @Override
    public void handleRequest(Request request) {
        System.out.println("CEO can approve anything");
    }
}
public class Director extends Handler{
    @Override
    public void handleRequest(Request request) {
        if(request.requestType()==RequestType.CONFERENCE){
            System.out.println("Director can approve conference");
        }else{
            successor.handleRequest(request);
        }
    }
}
public class VP extends Handler{
    @Override
    public void handleRequest(Request request) {
        if(request.requestType()==RequestType.PURCHASE){
            if(request.amount()<1500){
                System.out.println("Vp can approve budget <1500 ");
            }else{
                successor.handleRequest(request);
            }
        }
    }
}

// some class
public enum RequestType {
    CONFERENCE,
    PURCHASE
}

public record Request(
        RequestType requestType,
        double amount
) {
}

//client
public class Main {
    public static void main(String[] args) {

        var bryan=new Director();
        var crystal=new VP();
        var jeff=new CEO();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        var request =new Request(RequestType.CONFERENCE,500.0);
        bryan.handleRequest(request);

        request =new Request(RequestType.PURCHASE,1000.0);
        bryan.handleRequest(request);

        request =new Request(RequestType.PURCHASE,2000.0);
        bryan.handleRequest(request);

    }
}
