import java.time.LocalDateTime;

public class DaysDiscountCal implements DiscountCalculator{
    @Override
    public double getDiscountValue(LocalDateTime dateTime, int itemId) {

        // cal discount implementation
        return 10;
    }
}
