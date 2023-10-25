# Bridge Design Pattern

## Introduction

The Bridge Design Pattern is a structural design pattern that separates an object's abstraction from its implementation, allowing these two aspects to vary independently. It promotes loose coupling between an abstraction and its implementation, making the system more flexible and easier to extend.

This README provides an overview of the Bridge Design Pattern, its use cases, and a simple example to illustrate its implementation.

## Use Cases

The Bridge Design Pattern is commonly used when:

- You want to avoid a permanent binding between an abstraction and its implementation.
- You have multiple implementations for an abstraction and want to switch between them dynamically.
- You need to extend and maintain multiple hierarchies independently.

## Implementation

### Class Diagram

The Bridge Design Pattern involves the following components:

- **Abstraction**: Defines the interface for the abstraction, maintaining a reference to the implementation object.
- **Refined Abstraction**: Extends the abstraction, adding extra functionalities.
- **Implementation**: Defines the interface for implementing the abstraction.
- **Concrete Implementation**: Provides concrete implementations for the abstraction's interface.
- **Client**: Uses the abstraction to interact with the implementation, providing more flexibility in choosing the concrete implementation.

Here is a simplified UML class diagram to illustrate the structure:

![Bridge Design Pattern UML](bridge-pattern-uml.png)

### Example

In this example, we'll create a bridge pattern for multiable platform. We have two abstractions: `OperationSystem` , and three sets of concrete implementations: `Ios` and `Windows` for shapes, and `Linux`.

```java
# Abstraction
public interface OperatingSystem {
     void doOperation();
}


# Refined Abstraction
public class LinuxOS implements OperatingSystem{
    @Override
    public void doOperation() {
        System.out.println("Doing operation on linux platform");
    }
}

# Refined Abstraction
public class IOS implements OperatingSystem {
    @Override
    public void doOperation() {
        System.out.println("Doing operation on ios platform");
    }
}

# Refined Abstraction
public class WindowsOS implements OperatingSystem{
    @Override
    public void doOperation() {
        System.out.println("Doing operation on windows platform");
    }
}


# Implementation
public abstract class CommonUi {
    public OperatingSystem os;
    public CommonUi(OperatingSystem os){
        this.os=os;
    }
    public abstract void click();
}


# Concrete Implementation
public class Button extends CommonUi{
    public Button(OperatingSystem os) {
        super(os);
    }

    @Override
    public void click() {
        os.doOperation();
    }
}


# Client
public class Main {
    public static void main(String[] args) {
        //when to use :
        //  - Divide large class into two separate hierarchies
        //  - Switching from inheritance to composition
        //  - Multiplatform support ( switching impl at run time )


        WindowsOS windowOS=new WindowsOS();
        Button button=new Button(windowOS);
        button.click();

        System.out.println("==================");

        button.os=new LinuxOS();
        button.click();


    }
}
