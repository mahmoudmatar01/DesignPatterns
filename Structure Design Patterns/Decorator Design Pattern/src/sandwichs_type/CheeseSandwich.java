package sandwichs_type;

import basic_sandwich.Sandwich;
import decorator.SandwichDecorator;

public class CheeseSandwich extends SandwichDecorator {
    public CheeseSandwich(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public double getCost() {
        return super.getCost()+5;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" and cheese";
    }
}
