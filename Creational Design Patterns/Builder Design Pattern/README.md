# Builder Design Pattern

## Overview

The Builder Design Pattern is a creational design pattern that is used to construct a complex object step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Motivation

The Builder Design Pattern is used to address the following concerns:

1. **Complex Object Creation**: It simplifies the creation of complex objects with many optional components or parameters.

2. **Parameter Variation**: It allows for the construction of objects with different combinations of parameters, making it suitable for flexible object creation.

3. **Readability**: It improves the readability of code by providing a clear and expressive way to create objects with named parameters.

## Implementation

The Builder Design Pattern typically consists of the following components:

- **Director**: This class is responsible for orchestrating the construction process by working with a Builder.

- **Builder**: An interface or an abstract class defining the steps and methods to create an object.

- **Concrete Builder**: Concrete classes that implement the Builder interface and provide specific construction steps for the object.

- **Student**: The complex object that is being constructed. It may have multiple components or attributes.

## Usage

To use the Builder Design Pattern, follow these steps:

1. Create a concrete Builder class that implements the Builder interface, providing methods to set the attributes and components of the product.

2. Create a Director class that orchestrates the construction process, often by accepting a Builder object.

3. Use the Director and Builder to construct the complex object by invoking the Builder's methods in a specific order.

4. Retrieve the final Student from the Builder.

## Example

Consider a simple example of a Builder pattern that constructs a `Student` object:

```java
// Student class representing a complex object
public class Student {
    // normal class attributes
    private  String studentName;
    private  double gpa;
    private int id;
    private  String phone;

    public String getStudentName() {
        return studentName;
    }

    public double getGpa() {
        return gpa;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Student(String studentName, double gpa, int id, String phone) {
        this.studentName = studentName;
        this.gpa = gpa;
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", gpa=" + gpa +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }

    //builder Method
    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
}


// Builder interface
public interface IStudentBuilder {

     StudentBuilder setPhone(String phone);
     Student build();
     StudentBuilder setId(int id);
     StudentBuilder setGpa(double gpa);
     StudentBuilder setName(String name);
}


// Concrete StudentBuilder class
public class StudentBuilder implements IStudentBuilder {

    private  String studentName;
    private  double gpa;
    private int id;
    private  String phone;


    @Override
    public StudentBuilder setPhone(String phone) {
        this.phone=phone;
        return this;
    }

    @Override
    public Student build() {
        return new Student(
                studentName,gpa,id,phone
        );
    }

    //builder method

    @Override
    public StudentBuilder setId(int id) {
        this.id=id;
        return this;
    }

    @Override
    public StudentBuilder setGpa(double gpa) {
        this.gpa=gpa;
        return this;
    }

    @Override
    public StudentBuilder setName(String name) {
        this.studentName=name;
        return this;
    }

}

// client implementation
public class Main {
    public static void main(String[] args) {
        // Build complex objects step by step

        Student student =  Student.builder()
                .setId(1)
                .setName("mahmoud mohamed matar")
                .setPhone("+201128673348")
                .setGpa(3.1)
                .build();

        System.out.println(student.getId());
        System.out.println(student.getStudentName());
        System.out.println(student.getPhone());
        System.out.println(student.getGpa());

    }
}
