public class Main {
    public static void main(String[] args) {

        // Chain of Responsibility :-

        //                                     CEO" can approve anything "
        //                                      |
        // Sender ===request=|                  |
        //                   |                  |
        //                 st(1)ep           st(3)ep
        //                Director              |
        //                   |                  |
        //                   |                  |
        //                   | ---> st(2)ep---> VP" can approve budget < 1500 "

        var bryan=new Director();
        var crystal=new VP();
        var jeff=new CEO();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        var request =new Request(RequestType.CONFERENCE,500.0);
        bryan.handleRequest(request);

        request =new Request(RequestType.PURCHASE,1000.0);
        bryan.handleRequest(request);

        request =new Request(RequestType.PURCHASE,2000.0);
        bryan.handleRequest(request);

    }
}