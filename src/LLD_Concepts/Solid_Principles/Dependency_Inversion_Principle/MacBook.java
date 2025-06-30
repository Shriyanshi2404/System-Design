package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;

/**
 * Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules.
 * Suppose keyboard can be of two types: wiredKeyboard or wirelessKeyboard.
 * Similarly, mouse can be of two types: wiredMouse or wirelessMouse.
 * This principle encourages the decoupling of software modules, making them more flexible and easier to maintain.
 * In this example, we can use either wired or wireless keyboard and mouse with MacBook as it depends on Keyboard and Mouse interfaces rather than concrete classes.
 */

public class MacBook {
    private final Keyboard keyboard;
    private final Mouse mouse;

    MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public boolean isKeyboardWired() {
        return keyboard.isWired();
    }

    public boolean isMouseWired() {
        return mouse.isWired();
    }
}
