package basic_sandwich;

// concrete class
public class BasicSandwich implements Sandwich {
    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "it consists from only bread";
    }
}
