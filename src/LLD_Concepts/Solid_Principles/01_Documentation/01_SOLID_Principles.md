# SOLID Principles

The **SOLID** principles are a set of five design principles in object-oriented programming that help create maintainable, scalable, and robust software. These principles were introduced by Robert C. Martin (Uncle Bob).

## 1. Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change, meaning it should only have one job or responsibility.

**Example:** 
- ✅ **Good:** `Invoice` class handles calculation of total amount, `InvoicePrint` class handles printing, and `SaveInvoice` class handles saving to database - each class has a single responsibility.
- ❌ **Bad:** A single `Invoice` class handling calculation, printing, and saving all together.

## 2. Open/Closed Principle (OCP)

**Definition:** Software entities should be open for extension but closed for modification.

**Example:**
- ✅ **Good:** `PaymentProcessor` uses `PaymentMethod` interface, allowing new payment types like `CreditCard`, `PayPal`, `UPI` without modifying existing code.
- ❌ **Bad:** `PaymentProcessor` with if-else statements for each payment method, requiring modification every time a new payment type is added.

## 3. Liskov Substitution Principle (LSP)

**Definition:** If Class B is a subtype of Class A, then we should be able to replace object of A with object of B without breaking the behavior of the program.

**Example:**
- ✅ **Good:** `ReadableFile` and `WriteableFile` both implement proper file operations where `WriteableFile` extends `ReadableFile` capabilities.
- ❌ **Bad:** `ReadOnlyFile` extending `File` but throwing exception for `write()` method breaks the expected behavior.

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
- ✅ **Good:** `NotificationService` depends on `NotificationChannel` interface, allowing use of both `EmailService` and `SMSService` implementations.
- ❌ **Bad:** `NotificationService` directly depending on concrete `EmailService` and `SMSService` classes, making it tightly coupled.

---

## Benefits of Following SOLID Principles

- **Maintainability:** Code is easier to understand and modify
- **Flexibility:** Easy to extend functionality without breaking existing code
- **Testability:** Classes with single responsibilities are easier to test
- **Reusability:** Well-designed interfaces and abstractions can be reused
- **Reduced Coupling:** Dependencies on abstractions rather than concrete implementations 