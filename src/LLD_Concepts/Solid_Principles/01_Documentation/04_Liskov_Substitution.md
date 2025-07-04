# Liskov Substitution Principle (LSP) in Java

## Definition

> **"Objects of a superclass should be replaceable with objects of a subclass without altering the correctness of the program."**

In simpler terms: If class B(child class) is a subtype of class A (Superclass class), then we should be able to replace A with B without disrupting the behavior of our program.

## Bad Example - LSP Violation

Let's examine a classic example that violates LSP:

### The Problem Code

```java
// Super class
public class File {
    public void read(){
        System.out.println("reading from file...");
    }
    public void write(){
        System.out.println("Writing to file...");
    }
}

// Child class - This violates LSP
public class ReadOnlyFile extends File{
    @Override
    public void write(){
        throw new UnsupportedOperationException("Can't write to a read only file");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        File file = new ReadOnlyFile();
        file.read(); // works fine
        file.write(); // throws exception - LSP violation!
    }
}
```

### Why This Violates LSP

1. **Behavioral Inconsistency**: The `ReadOnlyFile` class throws an exception when `write()` is called, but the parent `File` class doesn't specify this behavior.

2. **Substitution Failure**: You cannot safely substitute a `ReadOnlyFile` object where a `File` object is expected because it changes the expected behavior.

3. **Precondition Strengthening**: The `ReadOnlyFile` adds a precondition that the file must not be written to, which wasn't present in the parent class.

---

## Good Example - LSP Compliance

Here's how we can redesign the above example to follow LSP:

### The Solution

```java
// Base interface for readable files
public interface Readable {
    void read();
}

// ReadableFile implementation
public class ReadableFile implements Readable {
    @Override
    public void read() {
        System.out.println("Reading from file...");
    }
}

// Writeable interface
public interface Writeable {
    void write();
}

// WriteableFile that supports both operations
public class WriteableFile extends ReadableFile implements Writeable {
    @Override
    public void write() {
        System.out.println("Writing to file...");
    }
}

// Proper usage
public class Main {
    
    public static void readAnyFile(ReadableFile file){
        file.read();
    }

    public static void main(String[] args) {
        ReadableFile readableFile = new ReadableFile();
        readableFile.read();

        WriteableFile writableFile = new WriteableFile();
        writableFile.read();
        writableFile.write();

        // Both can be used interchangeably where ReadableFile is expected which follow LisKov substitution principle
        readAnyFile(readableFile);
        readAnyFile(writableFile);
    }
}
```

### Why This Follows LSP

1. **Behavioral Consistency**: Both `ReadableFile` and `WriteableFile` can be used wherever `ReadableFile` is expected.

2. **No Unexpected Exceptions**: The `WriteableFile` doesn't throw exceptions for operations that the parent supports.

3. **Proper Inheritance Hierarchy**: The design uses composition of interfaces to build capabilities rather than forcing incompatible behaviors.

---

## Another Example - Bike and Cycle

Let's look at another example that shows LSP violation:

### The Problem

```java
public interface Bike {
    void turnOnEngine();
    void accelerate(int speed);
}

public class Cycle implements Bike {
    private int speed;

    public Cycle() {
        this.speed = 0;
    }

    @Override
    public void turnOnEngine() {
        // Cycles do not have engines!
        throw new UnsupportedOperationException("Cycles do not have engines.");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Cycling at speed: " + speed + " km/h");
    }
}
```

### The LSP Violation

The `Cycle` class violates LSP because:
- It throws an exception for `turnOnEngine()` method
- A `Cycle` cannot be safely substituted wherever a `Bike` is expected
- The interface contract is broken

### A Better Design

```java
public interface Vehicle {
    void accelerate(int speed);
}

public interface EngineVehicle extends Vehicle {
    void turnOnEngine();
}

public class MotorCycle implements EngineVehicle {
    private int speed;

    @Override
    public void turnOnEngine() {
        System.out.println("Engine started!");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Motorcycle accelerating at: " + speed + " km/h");
    }
}

public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Bicycle accelerating at: " + speed + " km/h");
    }
}
```

---

## Benefits of Following LSP

1. **Improved Code Reusability**: Subtypes can be used interchangeably with their base types.

2. **Better Maintainability**: Changes to subclasses don't break existing code that depends on the base class.

3. **Enhanced Polymorphism**: True polymorphic behavior where objects can be treated uniformly.

4. **Reduced Coupling**: Less dependency on specific implementations.

5. **Fewer Runtime Errors**: Eliminates unexpected exceptions and behavioral inconsistencies.

---


## Conclusion

The Liskov Substitution Principle is fundamental to creating robust, maintainable object-oriented designs. By ensuring that subclasses can be substituted for their base classes without breaking functionality, we create more flexible and reliable software.

Key takeaways:
- **Inheritance should model "is-a" relationships correctly**
- **Subclasses should extend, not replace, the behavior of their parent classes**
- **Design interfaces and abstract classes that truly represent common contracts**
- **Test substitutability to ensure LSP compliance**

Following LSP leads to better polymorphism, reduced coupling, and more maintainable code that can evolve gracefully over time.

---

**Remember**: LSP is not just about avoiding exceptions in overridden methods; it's about maintaining the behavioral contract that clients expect from the base class.
