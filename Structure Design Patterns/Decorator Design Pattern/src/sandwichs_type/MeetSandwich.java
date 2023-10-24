package sandwichs_type;

import basic_sandwich.Sandwich;
import decorator.SandwichDecorator;

public class MeetSandwich extends SandwichDecorator {
    public MeetSandwich(Sandwich sandwich) {
        super(sandwich);
    }
    @Override
    public double getCost() {
        return super.getCost()+20;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+",cheese and meet";
    }
}
