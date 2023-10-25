import java.time.LocalDateTime;

public class ItemPriceDiscount implements DiscountCalculator{

    // cal item price discount value
    @Override
    public double getDiscountValue(LocalDateTime dateTime, int itemId) {
        return 5;
    }
}
