import java.time.LocalDateTime;

public interface DiscountCalculator {
    double getDiscountValue(LocalDateTime dateTime,int itemId);
}
