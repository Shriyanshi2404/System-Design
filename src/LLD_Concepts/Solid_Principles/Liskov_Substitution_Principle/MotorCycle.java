package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle;

public class MotorCycle implements Bike {
    private final String model;
    private int speed;
    boolean isEngineOn;

    public MotorCycle(String model) {
        this.model = model;
        this.speed = 0;
    }

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
        System.out.println(model + " engine started.");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println(model + " is now going at " + this.speed + " km/h.");
    }
}
