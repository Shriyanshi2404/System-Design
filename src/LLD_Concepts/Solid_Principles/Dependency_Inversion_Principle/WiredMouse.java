package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;

public class WiredMouse implements Mouse {
    @Override
    public boolean isWired() {
        return true; // This is a wired mouse, so it returns true
    }
}
