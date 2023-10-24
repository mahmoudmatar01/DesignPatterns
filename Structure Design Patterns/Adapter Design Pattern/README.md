# Adapter Design Pattern

## Introduction

The Adapter Design Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, making them compatible without changing their source code.

This README provides an overview of the Adapter Design Pattern, its use cases, and a simple example to illustrate its implementation.

## Use Cases

The Adapter Design Pattern is commonly used when:

- You want to use a class that's incompatible with the rest of your system.
- You have a legacy codebase that you need to integrate with new code.
- You're working with third-party libraries or APIs that have different interfaces.

## Implementation

### Class Diagram

The Adapter Design Pattern involves the following components:

- **Target Interface**: Defines the interface that the client code expects.
- **Adaptee**: The class that has the functionality you want to adapt to the target interface.
- **Adapter**: A class that implements the target interface and wraps the Adaptee to make it compatible with the client code.
- **Client**: The code that relies on the Target Interface.


### Example

In this example, we'll create an Adapter for converting Bicycle Vehicle to Car Vehicle.

```python
# Target Interface
public interface Vehicle {

    String accelerate();
    String pushBreaking();
    String soundHorn();
}


# Adaptee
public class Car implements Vehicle{
    @Override
    public String accelerate() {
        return "car starts moving";
    }

    @Override
    public String pushBreaking() {
        return "car stopped";
    }

    @Override
    public String soundHorn() {
        return "Beep Beeb";
    }
}


# Adapter
public class Bicycle {

    public String pedal(){
        return "Bicycle Starts Moving";
    }

    public String ringBell(){
        return "Ring Bell";
    }

    public String stop(){
        return "Bicycle starts stop";
    }
}

public class BicycleAdapter implements Vehicle{

    private final Bicycle bicycle;

    public BicycleAdapter(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String accelerate() {
        return bicycle.pedal();
    }

    @Override
    public String pushBreaking() {
        return bicycle.stop();
    }

    @Override
    public String soundHorn() {
        return bicycle.ringBell();
    }
}


# Client
public class Main {
    public static void main(String[] args) {

        Vehicle car=new Car();
        vehicleStartWork(car);

        System.out.println("====================================");
        // lets make bicycle object
        Vehicle bicycle=new BicycleAdapter(new Bicycle());
        vehicleStartWork(bicycle);
    }

    private static void vehicleStartWork(Vehicle vehicle) {
        System.out.println(vehicle.accelerate());
        System.out.println(vehicle.pushBreaking());
        System.out.println(vehicle.soundHorn());
    }
}
