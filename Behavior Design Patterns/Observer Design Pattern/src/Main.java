public class Main {
    public static void main(String[] args) {

        // subject (Observable) :
        //       - Hold any number of observers
        //       - Hold state
        //       - Concrete implementation : Send notification to observers

        // Observer :
        //       - Method to update ( listener )

        Product iPhone=new Product("iphone 11 pro max");
        Person mahmoud=new Person("Mahmoud");
        Person ahmed=new Person("Ahmed");
        Person mustafa=new Person("Mustafa");

        iPhone.subscribe(mahmoud);
        iPhone.subscribe(ahmed);
        System.out.println("============================");
        iPhone.setAvailablity(true);
        System.out.println("============================");
        iPhone.setAvailablity(false);
        System.out.println("============================");
        iPhone.unSubscribe(ahmed);
        iPhone.unSubscribe(mahmoud);
        System.out.println("============================");
        iPhone.subscribe(mustafa);
        iPhone.setAvailablity(true);

    }
}