package exception;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Enter valid Card Number");
        System.out.println(e.getMessage().toString());;
    }
}
