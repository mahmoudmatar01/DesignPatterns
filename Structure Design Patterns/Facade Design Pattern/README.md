# Facade Design Pattern

## Introduction

The Facade Design Pattern is a structural design pattern that provides a simplified and unified interface to a set of interfaces within a subsystem. It encapsulates the complexity of the underlying system and provides a higher-level, easy-to-use interface for clients. The Facade pattern promotes loose coupling between clients and subsystems, making the system more manageable.

This README provides an overview of the Facade Design Pattern, its use cases, and a simple example to illustrate its implementation.

## Use Cases

The Facade Design Pattern is commonly used when:

- You need to simplify a complex system with many components or subsystems.
- You want to provide a unified interface to a group of interfaces that are otherwise hard to use individually.
- You want to hide the internal details and complexities of a subsystem from clients.

## Implementation

### Class Diagram

The Facade Design Pattern involves the following components:

- **Facade**: This is the main entry point for clients. It provides a simplified interface to access the subsystem's functionality.
- **Subsystem Classes**: These are the individual components or classes that make up the subsystem. The Facade uses these classes to perform the required operations.
- **Client**: The code that interacts with the Facade to access the subsystem's functionality.


### Example

In this example, we'll create a simple Facade for a  Home Theater, which hides the complexities of starting and preparing party.

```java
# Facade
public class HomeTheaterFacade {

    private Projector projector;
    private Amplifier amplifier;
    private PopCornPopper popCornPopper;
    private Screen screen;
    private StreamPlayer streamPlayer;
    private TheaterLights theaterLights;
    private  Tuner tuner;

    public HomeTheaterFacade(){
        projector=new Projector();
        amplifier=new Amplifier();
        popCornPopper=new PopCornPopper();
        screen=new Screen();
        streamPlayer=new StreamPlayer();
        theaterLights=new TheaterLights();
        tuner=new Tuner();
    }

    public void watchMovie(String name){
        popCornPopper.on();
        popCornPopper.pop();
        theaterLights.dim();
        screen.down();
        projector.on();
        projector.wideScreen();
        amplifier.on();
        amplifier.setStreamingPlayer(streamPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume();
        streamPlayer.on();
        streamPlayer.play(name);
    }

}


# Subsystem Classes
public class Amplifier {
    public void on(){
        System.out.println("amplifier starts on");
    }
    public void setStreamingPlayer(StreamPlayer streamPlayer){
        System.out.println("amplifier starts setting stream player");
    }
    public void setSurroundSound(){
        System.out.println("amplifier starts setting surround sound");
    }
    public void setVolume(){
        System.out.println("amplifier starts setting volume");
    }
}
public class PopCornPopper {

    public void on(){
        System.out.println("PopCornPopper starts on");
    }

    public void pop(){
        System.out.println("PopCornPopper starts pop");
    }
}
public class Projector {

   public void on(){
       System.out.println("Projector starts on");
   }
    public void wideScreen(){
        System.out.println("Projector starts doing widescreen");
    }
}
public class Screen {
    public void down(){
        System.out.println("Screen starts down");
    }
}
public class StreamPlayer {
   public void play(String name){
       System.out.println("stream player playing");
   }
    public void on(){
        System.out.println("stream player starts on");
    }
}
public class TheaterLights {

   public void dim(){
      System.out.println("TheaterLights starts dim");
   }
}
public class Tuner {
    public Tuner(){
        System.out.println("Tuner starts on");
    }
}


# Client
public class Main {
    public static void main(String[] args) {

// Client ====do something==>  (Facade)  ====connect with==> Complex Class

//                      |-> class 1
// Client ==> Facade ==>|-> class 2
//                      |-> class 3

        HomeTheaterFacade homeTheaterFacade=new HomeTheaterFacade();
        homeTheaterFacade.watchMovie("Movie Name");


    }
}

