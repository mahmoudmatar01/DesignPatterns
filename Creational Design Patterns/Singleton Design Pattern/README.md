# Singleton Design Pattern

The Singleton design pattern is a creational design pattern that restricts the instantiation of a class to a single instance. It ensures that there's only one global point of access to that instance, making it useful for scenarios where you want to control access to a shared resource, manage a single configuration manager, or implement a cache.

## Table of Contents
- [Motivation](#motivation)
- [Implementation](#implementation)
- [Usage](#usage)


## Motivation

The Singleton pattern addresses the following concerns:

1. **Control**: It limits the number of instances of a class to one, preventing unintended multiple instances.

2. **Global Point of Access**: It provides a single point of access to the single instance, which can be used throughout the application.

3. **Lazy Initialization**: It allows for the creation of the instance only when needed, improving resource utilization.

## Implementation

The Singleton pattern is typically implemented using the following key components:

1. **Private Constructor**: The class has a private constructor to prevent direct instantiation from outside the class.

2. **Private Instance**: The class contains a private static instance of itself.

3. **Public Method**: It provides a public static method to access the instance, usually named `getInstance()`. This method ensures that only one instance is created and returned.

4. **Thread Safety**: To support multi-threading, you can use techniques like double-checked locking or synchronization to ensure that only one instance is created, even in a multi-threaded environment.

## Usage

To use the Singleton pattern in your project:

1. Obtain an instance of the Singleton class using the `getInstance` method:

   ```java
   MySingleton instance = MySingleton.getInstance();

## Example

Consider a simple example of a Singleton pattern for Counter Class:

```java
// Counter Class
public class SingletonCounterClass {

    // Singleton Pattern : Only create one instance of a class

    public int count;
    public void addOne(){
        count++;
    }

    // create private constructor of this class and an instance

    private SingletonCounterClass(){}
    private static SingletonCounterClass Counter =null;

    public static SingletonCounterClass getInstance(){

        if(Counter==null){
            // to support multi-threading ==> you can use double-checked locking or an alternative approach using synchronized blocks.
            //The synchronized block is used to protect the critical section of code where the instance is created. Double-checked locking is an optimization that minimizes the overhead of synchronization after the first instance has been created.
            synchronized (SingletonCounterClass.class) {
                if (Counter == null) {
                    Counter = new SingletonCounterClass();
                }
            }
        }
        return Counter;
    }
}


// client implementation
public class Main {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        SingletonCounterClass counterOne = SingletonCounterClass.getInstance();
        SingletonCounterClass counterTwo = SingletonCounterClass.getInstance();

        counterOne.count=12;
        System.out.println(counterOne.count); // 12
        System.out.println(counterTwo.count); // 12

        counterOne.addOne();
        System.out.println(counterOne.count); // 13
        System.out.println(counterTwo.count); // 13

        counterTwo.count=2;
        counterTwo.addOne();
        System.out.println(counterOne.count); // 3
        System.out.println(counterTwo.count); // 3
    }
}
   

## Thread Safety

To ensure thread safety, you can employ various techniques such as double-checked locking, synchronized blocks, or the Bill Pugh Singleton pattern. The choice of technique depends on your specific requirements and the version of Java you are using.   


