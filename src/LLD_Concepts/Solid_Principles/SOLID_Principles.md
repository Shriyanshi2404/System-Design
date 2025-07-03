# SOLID Principles

The **SOLID** principles are a set of five design principles in object-oriented programming that help create maintainable, scalable, and robust software. These principles were introduced by Robert C. Martin (Uncle Bob).

## 1. Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change, meaning it should only have one job or responsibility.

**Example:** 
- ✅ **Good:** `Invoice` class handles the calculation of total amount of marker, while a separate class handles the printing of the invoice.
- ❌ **Bad:** A single class handling both invoice calculation and printing.

## 2. Open/Closed Principle (OCP)

**Definition:** Software entities should be open for extension but closed for modification.

**Example:**
- ✅ **Good:** If we want to save Invoice in a different format, we can create new classes like `SaveToDB` and `SaveToFile` that extend the Invoice class without modifying the original class.
- ❌ **Bad:** Modifying the existing Invoice class every time we need a new save format.

## 3. Liskov Substitution Principle (LSP)

**Definition:** If Class B is a subtype of Class A, then we should be able to replace object of A with object of B without breaking the behavior of the program.

**Example:**
- ✅ **Good:** `Bike` has a method to start the engine. If we have a `Car`, we can override the method to start the engine appropriately.
- ❌ **Bad:** If we create a subclass `Cycle` that does not have an engine, it should not override the start method in a way that breaks the functionality expected from the `Bike` class.

## 4. Interface Segregation Principle (ISP)

**Definition:** Interfaces should be designed to be client-specific, and clients should not implement unnecessary functions which are of no use.

**Example:**
- ✅ **Good:** We have two separate interfaces:
  - `Chef_Interface` with method `cookFood()`
  - `Waiter_Interface` with method `serveFood()`
- ❌ **Bad:** If class `Chef` implements both interfaces, then the `serveFood()` method is not relevant to its role. We should implement separate interfaces for Chef and Waiter.

## 5. Dependency Inversion Principle (DIP)

**Definition:** Classes should depend on interfaces or abstractions, not on concrete classes.

**Example:**
- ✅ **Good:** If we have two types of Keyboard and Mouse (wired and wireless), we should create interfaces for `Keyboard` and `Mouse`. The classes that use these interfaces should depend on the interfaces, not on the concrete classes.
- ❌ **Bad:** Directly depending on concrete classes like `WiredKeyboard` or `WirelessMouse`.

This approach allows us to easily switch between wired and wireless implementations without changing the code that uses them.

---

## Benefits of Following SOLID Principles

- **Maintainability:** Code is easier to understand and modify
- **Flexibility:** Easy to extend functionality without breaking existing code
- **Testability:** Classes with single responsibilities are easier to test
- **Reusability:** Well-designed interfaces and abstractions can be reused
- **Reduced Coupling:** Dependencies on abstractions rather than concrete implementations 