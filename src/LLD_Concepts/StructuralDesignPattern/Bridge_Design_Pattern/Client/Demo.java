package LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Client;

import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses.Dog;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses.Fish;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses.LivingThings;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses.Tree;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor.GillBreathing;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor.LungBreathing;
import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor.Photosynthesis;

// Client
public class Demo {

    public static void main(String[] args)
    {
        System.out.println("======= Bridge Design Pattern - Problem Demo ======");
        LivingThings dog = new Dog(new LungBreathing());
        dog.breathe();
        LivingThings fish = new Fish(new GillBreathing());
        fish.breathe();
        LivingThings tree = new Tree(new Photosynthesis());
        tree.breathe();
    }
}
