package LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern;

import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base.BasePizza;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base.Farmhouse;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base.Margeritha;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.Base.VeggieDelight;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.ToppingDecorator.ExtraCheeseTopping;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.ToppingDecorator.ExtraMushroomTopping;
import LLD_Concepts.StructuralDesignPattern.Decorator_Design_Pattern.ToppingDecorator.ToppingDecorator;

/**
 * The Decorator Design Pattern allows behavior to be added to individual objects, either statically or dynamically,
 * without affecting the behavior of other objects from the same class.
 * In this example, we are decorating pizzas with toppings.
 */
public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza = new Margeritha();
        System.out.println("Margeritha pizza" + " costs: " + pizza.costOfPizza());

        ToppingDecorator cheeseTopping = new ExtraCheeseTopping(pizza);
        System.out.println(cheeseTopping.pizzaName() + " costs: " + cheeseTopping.costOfPizza());

        pizza = new Farmhouse();
        System.out.println("Farmhouse pizza" + " costs: " + pizza.costOfPizza());

        ToppingDecorator mushroomTopping= new ExtraMushroomTopping(pizza);
        System.out.println(mushroomTopping.pizzaName() + " costs: " + mushroomTopping.costOfPizza());

        pizza = new VeggieDelight();
        System.out.println("Veggie Delight pizza" + " costs: " + pizza.costOfPizza());

        cheeseTopping = new ExtraCheeseTopping(pizza);
        mushroomTopping = new ExtraMushroomTopping(cheeseTopping);
        System.out.println(mushroomTopping.pizzaName() + " costs: " + mushroomTopping.costOfPizza());
    }
}
