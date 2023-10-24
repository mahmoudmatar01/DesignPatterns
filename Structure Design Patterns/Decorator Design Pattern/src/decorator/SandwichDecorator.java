package decorator;

import basic_sandwich.Sandwich;

// decorator abstract class
public abstract class SandwichDecorator implements Sandwich {

    private Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public double getCost() {
        return sandwich.getCost();
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription();
    }
}
