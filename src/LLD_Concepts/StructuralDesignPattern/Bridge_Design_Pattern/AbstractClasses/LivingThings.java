package LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.AbstractClasses;

import LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor.BreathingProcess;

//Step 3: Abstraction for LivingThings
public abstract class LivingThings {
    // Reference to Implementor
    BreathingProcess breathingProcess;

    // Bridge connects Animal with Breathing
    public LivingThings(BreathingProcess breathingProcess)
    {
        this.breathingProcess = breathingProcess;
    }

    // Operation implemented by Implementor
    abstract public void breathe();
}
