public class Person implements Observer{

    private String name;
    public Person(String name){
        this.name=name;
    }

    @Override
    public void listen(String message) {
        System.out.println(name+" Got new notification : "+message);
    }
}
