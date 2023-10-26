
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



