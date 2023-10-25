import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DiscountCalFactory discountCalFactory=new DiscountCalFactory();
        DiscountCalculator calculator=discountCalFactory.getDiscountValue("Items");
        double discount=calculator.getDiscountValue(LocalDateTime.now(),1);
        System.out.println(discount);
    }
}