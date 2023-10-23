public class Main {
    public static void main(String[] args) {

        Counter counter1=new Counter();
        Counter counter2=new Counter();
        counter1.count=12;  // count1 =12;
        counter1.addOne();  // count1 = 12 + 1 = 13

        System.out.println(counter1.count); // 13
        System.out.println(counter2.count); // 0

        counter2.count=2;
        counter1.addOne();
        System.out.println(counter1.count); // 13 + 1 =14
        System.out.println(counter2.count); // 2

        counter2.addOne();
        counter1.addOne();
        System.out.println(counter1.count); // 14 + 1 =15
        System.out.println(counter2.count); // 3


        System.out.println("====================================================================");
        // ------------------------------- Let's apply the Singleton pattern ---------------------
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