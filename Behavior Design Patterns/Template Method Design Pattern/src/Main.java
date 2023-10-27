public class Main {
    public static void main(String[] args) {

        //Uml :-
        // AbstractBase              ConcreteClass
        // + templateMethod  --->     // #methodOne()
        //  #methodOne()             // #methodTwo()
        //  #methodTwo()

        MakePizzaAlgorithm rectanglePizza=new MakeRectanglePizza();
        rectanglePizza.makePizza();

        System.out.println("====================");
        MakePizzaAlgorithm roundedPizza=new MakeRoundedPizza();
        roundedPizza.makePizza();
    }
}