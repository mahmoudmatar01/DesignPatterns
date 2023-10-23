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
