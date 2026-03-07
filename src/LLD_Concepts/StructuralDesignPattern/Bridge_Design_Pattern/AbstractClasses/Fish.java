package LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses;

import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor.BreathingProcess;

//Step 4: Refined Abstractions (Concrete LivingThings)
public class Fish extends LivingThings {

    public Fish(BreathingProcess breathingProcess)
    {
        super(breathingProcess);
    }

    @Override
    public void breathe()
    {
        System.out.print("Fish: ");
        breathingProcess.breathe(); // Operation implemented by Implementor - defines the "HOW"
    }
}
