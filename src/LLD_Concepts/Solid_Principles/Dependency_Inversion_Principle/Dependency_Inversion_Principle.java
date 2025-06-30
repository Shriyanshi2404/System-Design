package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle;
/**
 * Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules.
 * Class should depend on interfaces rather than concrete classes.
 * This principle encourages the decoupling of software modules, making them more flexible and easier to maintain.
 * In this example, we demonstrate how to apply the DIP by creating a MacBook that depends on abstractions for keyboard and mouse.
 */
public class Dependency_Inversion_Principle {

    public static void main(String[] args) {
        Keyboard wiredKeyboard = new WiredKeyboard();
        Mouse wirelessMouse = new WirelessMouse();

        MacBook macBook = new MacBook(wiredKeyboard, wirelessMouse);
        System.out.println("Macbook is connected with wired keyboard: " + macBook.isKeyboardWired());
        System.out.println("Macbook is connected with wired mouse: " + macBook.isMouseWired());
    }
}
