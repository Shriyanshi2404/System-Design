package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle;

public class Cycle implements Bike {
    private int speed;

    public Cycle() {
        this.speed = 0;
    }

    @Override
    public void turnOnEngine() {
        // Cycles do not have engines, so this method can be left empty or throw an exception
        throw new UnsupportedOperationException("Cycles do not have engines.");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Cycling at speed: " + speed + " km/h");
    }
}
