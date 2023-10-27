public abstract class MakePizzaAlgorithm {

    private void bakePizza(){
        System.out.println("Baking Pizza");
    }

    abstract void definePizzaShape();

    private void putAddons(){
        System.out.println("Putting Pizza Addons");
    }

    private void heatPizza(){
        System.out.println("Heating Pizza");
    }

    public void makePizza(){
        bakePizza();
        definePizzaShape();
        putAddons();
        heatPizza();
    }
}
