# Prototype Design Pattern

## Overview

The Prototype Design Pattern is a creational design pattern that is used for creating objects by copying an existing object, known as the prototype. It allows you to create new objects with the same state as the prototype, enabling efficient object creation while maintaining loose coupling.

## Motivation

The Prototype Design Pattern is used to address the following concerns:

1. **Object Creation**: It simplifies the process of creating new objects by copying existing ones, which can be particularly useful when objects are complex or expensive to create.

2. **Variation**: It allows you to create new objects with different initial states, based on the prototype, by modifying or customizing the copied attributes.

3. **Performance**: It can improve performance by avoiding the cost of initializing an object from scratch when a similar object already exists.

## Implementation

The Prototype Design Pattern typically consists of the following components:

- **Prototype**: An interface or an abstract class defining a method to clone the object.

- **Concrete Prototype**: Classes that implement the Prototype interface or extend the Prototype abstract class, providing the actual cloning logic.

- **Client**: The class responsible for creating and using the prototype objects.

## Usage

To use the Prototype Design Pattern, follow these steps:

1. Create a prototype class (either as an interface or an abstract class) with a `clone` method to copy the object.

2. Implement concrete prototype classes that provide the specific cloning behavior for their instances.

3. In the client code, create new objects by cloning the prototype, customizing their attributes as needed.

4. The client code should use the cloned objects as required.

## Example

Consider a simple example of a Prototype pattern that creates different types of Employee:

```java
// Employee abstract class
public abstract  class EmployeeProtoType implements Cloneable{

    public int id;
    public String name;
    public Address address;


    public abstract EmployeeProtoType shallowCopy() throws CloneNotSupportedException;
    public abstract EmployeeProtoType DeepCopy() throws CloneNotSupportedException;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "EmployeeProtoType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

// Address class
public class Address {
   public String cityName;
   public String streetName;

    public Address(String cityName,String streetName) {
        this.cityName = cityName;
        this.streetName=streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}


// Concrete implementations
public class RegEmployee extends EmployeeProtoType{
    @Override
    public EmployeeProtoType shallowCopy() throws CloneNotSupportedException {
        return (RegEmployee) this.clone();
    }

    @Override
    public EmployeeProtoType DeepCopy() throws CloneNotSupportedException {
        RegEmployee emp=new RegEmployee();
        emp=(RegEmployee) this.clone();
        emp.name=this.name;
        emp.address=new Address(
                this.address.cityName,
                this.address.streetName
        );
        emp.id=this.id;
        return emp;
    }

    @Override
    public String toString() {
        return "RegEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}



public class TempEmployee extends EmployeeProtoType{
    @Override
    public EmployeeProtoType shallowCopy() throws CloneNotSupportedException {
        return (TempEmployee) this.clone();
    }

    @Override
    public EmployeeProtoType DeepCopy() throws CloneNotSupportedException {
        TempEmployee emp=new TempEmployee();
        emp=(TempEmployee) this.clone();
        emp.name=this.name;
        emp.id=this.id;
        emp.address=new Address(
                this.address.cityName,
                this.address.streetName
        );
        return emp;
    }

    @Override
    public String toString() {
        return "TempEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}


// client implementation

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        EmployeeProtoType tempEmployee=new TempEmployee();
        tempEmployee.name="mahmoud";
        tempEmployee.id=1;
        tempEmployee.address=new Address("Tanta","Nefia");

        EmployeeProtoType tempEmployee2=tempEmployee.shallowCopy();
        EmployeeProtoType tempEmployee3=tempEmployee.DeepCopy();
        System.out.println("Temp 1 Original");
        System.out.println(tempEmployee.toString());
        System.out.println("Temp 2 Copy");
        System.out.println(tempEmployee2.toString());

        System.out.println("==========================");

        tempEmployee2.address.streetName="new Street";
        System.out.println("Temp 1 Original");
        System.out.println(tempEmployee.toString());
        System.out.println("Temp 2 Copy");
        System.out.println(tempEmployee2.toString());
        System.out.println("Temp 3 Deep Copy");
        System.out.println(tempEmployee3.toString());



    }
}
