# Static Keyword Concepts in Java

## Overview
The `StaticKeywordConcepts.java` file provides a comprehensive demonstration of all static keyword concepts in Java, including variables, methods, blocks, nested classes, and various practical scenarios.

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line access

### Compilation
```bash
# Navigate to the src directory
cd src

# Compile the Java file
javac LLD_Concepts/StaticKeywordConcepts.java

# This will also compile the additional classes:
# - StaticInitializationOrder
# - StaticMethodOverloading  
# - Parent and Child classes
```

### Execution
```bash
# Run the main class
java LLD_Concepts.StaticKeywordConcepts
```

## Expected Output
The program will demonstrate:
1. Static variables and methods without object creation
2. Static variable sharing among instances
3. Static nested class functionality
4. Non-static inner class comparison
5. Singleton pattern implementation
6. Counter class with static variables
7. Utility class with static methods
8. Static import demonstrations
9. Memory management aspects
10. Summary of all concepts

## Key Learning Points

### Static Variables
- Belong to the class, not individual instances
- Shared among all objects of the class
- Initialized when class is first loaded
- Stored in Method Area (Metaspace in Java 8+)

### Static Methods
- Can be called without creating class instances
- Cannot access instance variables or methods directly
- Perfect for utility functions and helper methods
- Cannot be overridden (they are hidden, not overridden)

### Static Blocks
- Execute when class is first loaded into memory
- Used for complex initialization of static variables
- Multiple static blocks execute in the order they appear

### Static Nested Classes
- Don't require outer class instance to be created
- Can access static members of outer class
- Cannot access instance members of outer class directly

### Best Practices
- Use static for utility methods and constants
- Avoid static for maintaining state (except specific cases like counters)
- Use static imports sparingly to avoid namespace pollution
- Consider memory implications of static variables

## File Structure
```
StaticKeywordConcepts.java
├── Main class with comprehensive examples
├── StaticNestedClass (inner static class)
├── InnerClass (non-static inner class)
├── Singleton (static singleton pattern)
├── Counter (static variable sharing)
├── MathUtils (utility class)
└── Additional demonstration classes
```

## Additional Classes
- `StaticInitializationOrder`: Demonstrates static block execution order
- `StaticMethodOverloading`: Shows static method overloading
- `Parent` and `Child`: Demonstrates static method hiding vs overriding 