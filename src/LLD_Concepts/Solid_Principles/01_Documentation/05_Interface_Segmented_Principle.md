# Interface Segregation Principle (ISP)

## Definition

> **"No client should be forced to depend on methods it does not use."**

This means that interfaces should be designed to be **client-specific** rather than **general-purpose**. Clients should not be forced to implement unnecessary methods that are of no use to them.

## The Problem

❌ **Bad Example**: Having one large interface with all methods
```java
// Violates ISP - All classes must implement all methods
interface RestaurantWorker {
    void cookFood(String dish);
    void takeOrder(String dish, int quantity);
    void serveFood();
    void washDishes();
}
```

**Problems with this approach:**
- A `Chef` class would be forced to implement `takeOrder()` and `serveFood()` methods
- A `Waiter` class would be forced to implement `cookFood()` and `washDishes()` methods
- This creates unnecessary dependencies and violates the principle

## The Solution

✅ **Good Example**: Separate interfaces for different responsibilities

### ChefInterface
```java
public interface ChefInterface {
    void cookFood(String dish);
}
```

### WaiterInterface
```java
public interface WaiterInterface {
    void takeOrder(String dish, int quantity);
    void serveFood();
}
```

### Implementation Classes

**Chef Class:**
```java
public class Chef implements ChefInterface {
    String dish;

    public Chef(String dish) {
        this.dish = dish;
    }

    @Override
    public void cookFood(String dish) {
        System.out.println("Cooking " + dish);
    }
}
```

**Waiter Class:**
```java
public class Waiter implements WaiterInterface {
    String dish;
    int quantity;

    public Waiter(String dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    @Override
    public void takeOrder(String dish, int quantity) {
        System.out.println("Taking order for " + quantity + " of " + dish);
    }

    @Override
    public void serveFood() {
        System.out.println("Serving " + this.dish);
    }
}
```

## Benefits

1. **Reduced Coupling**: Classes only depend on methods they actually use
2. **Better Maintainability**: Changes to one interface don't affect unrelated classes
3. **Flexibility**: Easy to add new implementations without breaking existing code
4. **Clear Responsibilities**: Each interface has a specific, well-defined purpose
5. **Easier Testing**: Smaller interfaces are easier to mock and test

## Key Points to Remember

- **Keep interfaces small and focused** - Each interface should have a single responsibility
- **Think from the client's perspective** - What does this client actually need?
- **Prefer composition over large interfaces** - Multiple small interfaces are better than one large interface
- **Avoid "fat" interfaces** - If an interface has many methods, consider splitting it

## Real-World Example

Instead of having one large `DatabaseInterface` with methods for all operations:
```java
// Bad - Violates ISP
interface DatabaseInterface {
    void read();
    void write();
    void backup();
    void restore();
    void optimize();
}
```

Create specific interfaces:
```java
// Good - Follows ISP
interface Readable {
    void read();
}

interface Writable {
    void write();
}

interface Backupable {
    void backup();
    void restore();
}
```

This way, a `ReadOnlyDatabase` only needs to implement `Readable`, and a `FullDatabase` can implement multiple interfaces as needed.

## Conclusion

The Interface Segregation Principle promotes **focused, client-specific interfaces** that make code more maintainable, flexible, and testable. By avoiding "fat" interfaces, we create systems that are easier to understand and modify.

---

*"Many client-specific interfaces are better than one general-purpose interface."* - Robert C. Martin
