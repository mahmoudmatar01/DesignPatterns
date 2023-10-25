# Composite Design Pattern

## Introduction

The Composite Design Pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly. The pattern is used to create complex structures from simple objects and to work with both individual objects and their compositions in a unified manner.

This README provides an overview of the Composite Design Pattern, its use cases, and a simple example to illustrate its implementation.

## Use Cases

The Composite Design Pattern is commonly used when:

- You need to represent part-whole hierarchies, such as a file system, organization structure, or graphical shapes.
- You want clients to treat individual objects and compositions of objects uniformly.
- You need to apply operations recursively to the components of a composite structure.

## Implementation

### Class Diagram

The Composite Design Pattern involves the following components:

- **Component**: Declares the interface for objects in the composition, both leaf objects and composites.
- **Leaf**: Represents individual objects that do not have any children. They implement the Component interface.
- **Composite**: Represents a composite object that can have children, which are components. It also implements the Component interface.
- **Client**: Uses the Component interface to work with both leaf and composite objects.

### Example

In this example, we'll create a simple composite structure to represent a Widgets structure.
```java
# Component
public abstract class Component {
    public String title;

    public Component(String title) {
        this.title = title;
    }

}


# Leafs
public class ImageView extends Component{
    public ImageView(String title) {
        super(title);
    }
}

public class Textview extends Component{
    public Textview(String title) {
        super(title);
    }
}
public class WebView extends Component{
    public WebView(String title) {
        super(title);
    }
}


# Composite
public class Container extends Component{
    private List<Component>children;
    public Container(String title,List<Component>children) {
        super(title);
        this.children=children;
    }

    public void printChildren(){
        System.out.println("============= Container Component ==========");
        children.stream().forEach(component -> {
            if(component instanceof Container){
                ((Container) component).children.stream().forEach(component1 -> System.out.println(component1.title));
            } else{
                System.out.println(component.title);
            }
        });
    }
}

# Client
public class Main {
    public static void main(String[] args) {


        Textview text1=new Textview("Name Text view");
        Textview text2=new Textview("Age Text view");
        ImageView profileImg=new ImageView("Profile Image");
        Container container=new Container("Container", List.of(
               text1,text2));
        Container nestedContainer=new Container(
                "Nested Container",List.of(
                        profileImg,container
        )
        );
       container.printChildren();
       nestedContainer.printChildren();
    }
}
