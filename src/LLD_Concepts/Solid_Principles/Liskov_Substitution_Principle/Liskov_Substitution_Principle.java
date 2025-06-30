package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle;

/**
 * Liskov Substitution Principle (LSP)
 * Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
 * This means that subclasses should extend the behavior of the parent class without changing its expected behavior.
 * Example: Bike interface can be implemented by MotorCycle and Cycle classes, allowing both to be used interchangeably.
 */
public class Liskov_Substitution_Principle {

    public static void main(String[] args) {

        Bike motorCycle = new MotorCycle("Yamaha");
        motorCycle.turnOnEngine();
        motorCycle.accelerate(60);

        Bike cycle = new Cycle();
        // Uncommenting the next line will throw an exception since cycles do not have engines
        // cycle.turnOnEngine();
        cycle.accelerate(15);
    }
}
