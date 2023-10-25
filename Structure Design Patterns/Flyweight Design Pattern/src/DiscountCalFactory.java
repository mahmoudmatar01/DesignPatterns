import java.util.HashMap;
import java.util.Map;

public class DiscountCalFactory {

    public DiscountCalculator getDiscountValue(String discountType){

        Map<String,DiscountCalculator>instancesDictionary=new HashMap<>();
        DiscountCalculator discountCalculator=null;

        if (instancesDictionary.containsKey(discountType)) {
           return instancesDictionary.get(discountType);
        }else{
            switch (discountType){
                case "Days":
                    discountCalculator=new DaysDiscountCal();
                    instancesDictionary.put(discountType,discountCalculator);
                    break;
                case "Items":
                    discountCalculator=new ItemPriceDiscount();
                    instancesDictionary.put(discountType,discountCalculator);
                    break;
                default:
                    break;
            }
        }
        return discountCalculator;
    }
}
