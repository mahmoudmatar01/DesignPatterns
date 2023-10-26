import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private String name;
    private String availablity;
    private List<Observer>observerList;

    public Product(String name){
        this.name=name;
        observerList=new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
        System.out.println("observer "+name+" has been added");
    }

    @Override
    public void unSubscribe(Observer observer) {
        observerList.remove(observer);
        System.out.println("observer "+name+" has been removed");
    }

    @Override
    public void sendNotification() {
        for (Observer observer:observerList){
            observer.listen(availablity);
        }
    }

    public void setAvailablity(boolean availablity) {
        this.availablity =this.name+(availablity?" Available":" Not available");
        sendNotification();
    }
}
