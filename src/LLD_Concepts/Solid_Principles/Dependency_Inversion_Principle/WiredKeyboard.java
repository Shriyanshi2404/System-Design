package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;

public class WiredKeyboard implements Keyboard {

    @Override
    public boolean isWired() {
        return true; // This is a wired keyboard, so it returns true
    }
}
