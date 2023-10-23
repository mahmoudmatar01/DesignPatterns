public class Counter {

// this Counter class, does not conform to the Singleton design pattern.
// In the Singleton pattern, a class is designed to ensure that only one instance
// of the class is created and that it provides a global point of access to that instance.
// The class you've shown allows multiple instances of Counter to be created,
// and it does not provide any mechanism to ensure a single, shared instance.

    // instance variable
    public int count;

    //Method
    public void addOne(){
        count++;
    }

}

