package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;

public class WirelessKeyboard implements Keyboard {
    @Override
    public boolean isWired() {
        return false; // This is a wireless keyboard, so it returns false
    }
}
