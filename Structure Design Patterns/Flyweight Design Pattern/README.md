# Flyweight Design Pattern

## Introduction

The Flyweight Design Pattern is a structural design pattern that aims to minimize memory or storage usage by sharing as much as possible with related objects. It is especially useful when you need to manage a large number of similar objects efficiently by separating intrinsic (shared) and extrinsic (non-shared) properties.

This README provides an overview of the Flyweight Design Pattern, its use cases, and a simple example to illustrate its implementation.

## Use Cases

The Flyweight Design Pattern is commonly used when:

- You have a large number of similar objects that can be shared.
- You want to reduce memory usage by sharing common properties.
- Objects have intrinsic and extrinsic properties, and you want to separate them to optimize memory usage.

## Implementation

### Class Diagram

The Flyweight Design Pattern involves the following components:

- **Flyweight Interface**: Defines the methods that the concrete flyweights must implement. It typically includes a method for receiving extrinsic data.
- **Concrete Flyweight**: Implements the Flyweight Interface and represents the shared intrinsic state. These objects are usually stateless or shareable.
- **Flyweight Factory**: Manages a pool of flyweights, ensuring that they are shared effectively and that new flyweights are created when needed.
- **Client**: Uses the Flyweight Factory to obtain and work with flyweights. It provides the extrinsic state to the flyweights.

### Example

In this example, we'll create a simple Flyweight pattern to represent different types of discounts calculator of items
```java

# Flyweight Interface
public interface DiscountCalculator {
    double getDiscountValue(LocalDateTime dateTime,int itemId);
}

# Concrete Flyweight
public class DaysDiscountCal implements DiscountCalculator{
    @Override
    public double getDiscountValue(LocalDateTime dateTime, int itemId) {

        // cal discount implementation
        return 10;
    }
}

public class ItemPriceDiscount implements DiscountCalculator{

    // cal item price discount value
    @Override
    public double getDiscountValue(LocalDateTime dateTime, int itemId) {
        return 5;
    }
}

# Flyweight Factory
public class DiscountCalFactory {

    public DiscountCalculator getDiscountValue(String discountType){

        Map<String,DiscountCalculator>instancesDictionary=new HashMap<>();
        DiscountCalculator discountCalculator=null;

        if (instancesDictionary.containsKey(discountType)) {
           return instancesDictionary.get(discountType);
        }else{
            switch (discountType){
                case "Days":
                    discountCalculator=new DaysDiscountCal();
                    instancesDictionary.put(discountType,discountCalculator);
                    break;
                case "Items":
                    discountCalculator=new ItemPriceDiscount();
                    instancesDictionary.put(discountType,discountCalculator);
                    break;
                default:
                    break;
            }
        }
        return discountCalculator;
    }
}


# Client
public class Main {
    public static void main(String[] args) {
        DiscountCalFactory discountCalFactory=new DiscountCalFactory();
        DiscountCalculator calculator=discountCalFactory.getDiscountValue("Items");
        double discount=calculator.getDiscountValue(LocalDateTime.now(),1);
        System.out.println(discount);
    }
}
