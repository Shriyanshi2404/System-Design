package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;

public class WirelessMouse implements Mouse {
    @Override
    public boolean isWired() {
        return false; // This is a wireless mouse, so it returns false
    }
}
