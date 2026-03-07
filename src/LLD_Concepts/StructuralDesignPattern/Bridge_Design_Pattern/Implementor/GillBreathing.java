package LLD_Concepts.StructuralDesignPattern.Bridge_Design_Pattern.Implementor;

// Step 2: Concrete Implementor (various breathing processes)
public class GillBreathing implements BreathingProcess {
    @Override
    public void breathe() {
        System.out.println("Breathing through gills.");
    }
}
