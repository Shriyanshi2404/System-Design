package LLD_Concepts.StaticKeywordConcept;

/**
 * Comprehensive demonstration of Static Keyword in Java
 * 
 * This file covers all concepts related to the 'static' keyword:
 * 1. Static Variables (Class Variables)
 * 2. Static Methods
 * 3. Static Blocks
 * 4. Static Nested Classes
 * 5. Static Imports
 * 6. Memory Management
 * 7. Common Scenarios and Use Cases
 * 8. Best Practices and Pitfalls
 */

// Static import example
import static java.lang.Math.*;
import static java.lang.System.out;

public class StaticKeywordConcepts {
    
    // ========== 1. STATIC VARIABLES (CLASS VARIABLES) ==========
    
    // Static variable - belongs to class, not instance
    // Shared among all instances of the class
    private static int staticCounter = 0;
    
    // Public static variable - accessible from anywhere
    public static String companyName = "TechCorp";
    
    // Final static variable - constant (must be initialized)
    public static final double PI = 3.14159;
    
    // Static variable with complex initialization
    private static String complexInitialization;
    
    // Instance variable for comparison
    private int instanceCounter = 0;
    private String instanceName;
    
    // ========== 2. STATIC BLOCKS ==========
    
    // Static block - executed when class is first loaded
    // Used for complex static variable initialization
    static {
        out.println("Static block 1 executed - Class loading");
        complexInitialization = "Initialized in static block";
        staticCounter = 100; // Initialize static variable
    }
    
    // Multiple static blocks are allowed and executed in order
    static {
        out.println("Static block 2 executed - Multiple static blocks");
        // Can perform complex initialization logic
        if (companyName.equals("TechCorp")) {
            staticCounter += 50;
        }
    }
    
    // Instance block for comparison
    {
        out.println("Instance block executed - Before constructor");
        instanceCounter++;
    }
    
    // ========== 3. CONSTRUCTORS ==========
    
    public StaticKeywordConcepts(String name) {
        out.println("Constructor called for: " + name);
        this.instanceName = name;
        staticCounter++; // Accessing static variable from constructor
    }
    
    // ========== 4. STATIC METHODS ==========
    
    /**
     * Static method - belongs to class, not instance
     * Can be called without creating object
     * Cannot access instance variables or methods directly
     */
    public static void displayClassInfo() {
        out.println("=== Class Information ===");
        out.println("Company Name: " + companyName);
        out.println("Static Counter: " + staticCounter);
        out.println("PI Value: " + PI);
        out.println("Complex Initialization: " + complexInitialization);
        
        // Cannot access instance variables directly
        // out.println(instanceName); // This would cause compilation error
        
        // Can call other static methods
        staticMethodHelper();
    }
    
    private static void staticMethodHelper() {
        out.println("Static helper method called");
    }
    
    /**
     * Static method with parameters
     */
    public static int addNumbers(int a, int b) {
        return a + b;
    }
    
    /**
     * Static method that returns static variable
     */
    public static int getStaticCounter() {
        return staticCounter;
    }
    
    /**
     * Static method to modify static variable
     */
    public static void resetStaticCounter() {
        staticCounter = 0;
    }
    
    // ========== 5. INSTANCE METHODS ==========
    
    /**
     * Instance method - can access both static and instance variables
     */
    public void displayInstanceInfo() {
        out.println("=== Instance Information ===");
        out.println("Instance Name: " + instanceName);
        out.println("Instance Counter: " + instanceCounter);
        
        // Can access static variables and methods
        out.println("Static Counter from instance: " + staticCounter);
        out.println("Company Name from instance: " + companyName);
        
        // Can call static methods
        staticMethodHelper();
    }
    
    /**
     * Instance method that modifies static variable
     */
    public void incrementStaticCounter() {
        staticCounter++;
        out.println("Static counter incremented to: " + staticCounter);
    }
    
    // ========== 6. STATIC NESTED CLASSES ==========
    
    /**
     * Static nested class - doesn't need outer class instance
     * Can access static members of outer class
     */
    public static class StaticNestedClass {
        private String nestedData;
        
        public StaticNestedClass(String data) {
            this.nestedData = data;
        }
        
        public void displayNestedInfo() {
            out.println("=== Static Nested Class Info ===");
            out.println("Nested Data: " + nestedData);
            
            // Can access static members of outer class
            out.println("Outer class static counter: " + staticCounter);
            out.println("Outer class company name: " + companyName);
            
            // Cannot access instance members directly
            // out.println(instanceName); // Compilation error
        }
        
        public static void staticNestedMethod() {
            out.println("Static method in static nested class");
            // Can access static members of outer class
            out.println("Accessing outer static counter: " + staticCounter);
        }
    }
    
    /**
     * Non-static nested class (Inner class) for comparison
     */
    public class InnerClass {
        private String innerData;
        
        public InnerClass(String data) {
            this.innerData = data;
        }
        
        public void displayInnerInfo() {
            out.println("=== Inner Class Info ===");
            out.println("Inner Data: " + innerData);
            
            // Can access both static and instance members of outer class
            out.println("Outer instance name: " + instanceName);
            out.println("Outer static counter: " + staticCounter);
        }
    }
    
    // ========== 7. STATIC VARIABLE SCENARIOS ==========
    
    /**
     * Singleton pattern using static
     */
    public static class Singleton {
        private static Singleton instance;
        private String data;
        
        // PRIVATE CONSTRUCTOR - Can only be called from within this class
        // PRIVATE CONSTRUCTOR - This is the KEY!
        // It prevents external classes from creating instances using 'new'
        private Singleton(String data) {
            this.data = data;
        }
        
        // Public static method to get the single instance
        public static Singleton getInstance(String data) {
            if (instance == null) {
                instance = new Singleton(data);
            }
            return instance;
        }
        
        // Public method to display data
        public void displayData() {
            out.println("Singleton data: " + data);
        }
    }
    
    /**
     * Counter class to demonstrate static variable sharing
     */
    public static class Counter {
        private static int count = 0;
        private int instanceId;
        
        public Counter() {
            count++;
            instanceId = count;
        }
        
        public void displayCount() {
            out.println("Instance ID: " + instanceId + ", Total instances: " + count);
        }
        
        public static int getTotalInstances() {
            return count;
        }
    }
    
    // ========== 8. UTILITY CLASS EXAMPLE ==========
    
    /**
     * Utility class with only static methods
     */
    public static class MathUtils {
        // Private constructor to prevent instantiation
        private MathUtils() {
            throw new AssertionError("Utility class should not be instantiated");
        }
        
        // can access this method without creating an instance of the class MathUtils.factorial(5)
        public static int factorial(int n) {
            if (n <= 1) return 1;
            return n * factorial(n - 1);
        }
        
        public static boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i <= sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
        
        public static double calculateCircleArea(double radius) {
            return PI * radius * radius;
        }
    }
    
    // ========== 9. MAIN METHOD AND DEMONSTRATIONS ==========
    
    public static void main(String[] args) {
        out.println("========== STATIC KEYWORD DEMONSTRATIONS ==========\n");
        
        // 1. Static variables and methods without object creation
        out.println("1. STATIC VARIABLES AND METHODS (No object needed):");
        displayClassInfo();
        out.println("Adding numbers using static method: " + addNumbers(5, 3));
        out.println();
        
        // 2. Creating objects and observing static variable sharing
        out.println("2. STATIC VARIABLE SHARING AMONG INSTANCES:");
        StaticKeywordConcepts obj1 = new StaticKeywordConcepts("Object1");
        StaticKeywordConcepts obj2 = new StaticKeywordConcepts("Object2");
        
        obj1.displayInstanceInfo();
        obj2.displayInstanceInfo();
        
        obj1.incrementStaticCounter();
        obj2.displayInstanceInfo(); // Shows updated static counter
        out.println();
        
        // 3. Static nested class demonstration
        out.println("3. STATIC NESTED CLASS:");
        StaticNestedClass nested = new StaticNestedClass("Nested Data");
        nested.displayNestedInfo();
        StaticNestedClass.staticNestedMethod();
        out.println();
        
        // 4. Non-static inner class demonstration
        out.println("4. NON-STATIC INNER CLASS:");
        InnerClass inner = obj1.new InnerClass("Inner Data");
        inner.displayInnerInfo();
        out.println();
        
        // 5. Singleton pattern demonstration
        out.println("5. SINGLETON PATTERN:");
        Singleton singleton1 = Singleton.getInstance("First Instance");
        Singleton singleton2 = Singleton.getInstance("Second Instance");
        singleton1.displayData();
        singleton2.displayData();
        out.println("Both references point to same object: " + (singleton1 == singleton2));
        out.println();
        
        // 6. Counter class demonstration
        out.println("6. COUNTER CLASS (Static variable sharing):");
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        
        counter1.displayCount();
        counter2.displayCount();
        counter3.displayCount();
        out.println("Total instances created: " + Counter.getTotalInstances());
        out.println();
        
        // 7. Utility class demonstration
        out.println("7. UTILITY CLASS:");
        out.println("Factorial of 5: " + MathUtils.factorial(5));
        out.println("Is 17 prime? " + MathUtils.isPrime(17));
        out.println("Circle area (radius 5): " + MathUtils.calculateCircleArea(5));
        out.println();
        
        // 8. Static import demonstration
        out.println("8. STATIC IMPORT DEMONSTRATION:");
        out.println("Using Math.sqrt via static import: " + sqrt(16));
        out.println("Using Math.pow via static import: " + pow(2, 3));
        out.println("Using Math.PI via static import: " + PI);
        out.println();
        
        // 9. Memory and performance considerations
        out.println("9. MEMORY CONSIDERATIONS:");
        demonstrateMemoryAspects();
        
        out.println("\n========== SUMMARY ==========");
        printSummary();
    }
    
    /**
     * Demonstrates memory aspects of static variables
     */
    public static void demonstrateMemoryAspects() {
        out.println("Static variables are stored in Method Area (Metaspace in Java 8+)");
        out.println("They are loaded when class is first referenced");
        out.println("They exist throughout the lifetime of the program");
        out.println("Current static counter value: " + staticCounter);
        
        // Create multiple objects to show static variable sharing
        StaticKeywordConcepts[] objects = new StaticKeywordConcepts[3];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new StaticKeywordConcepts("Object" + i);
        }
        
        out.println("After creating 3 more objects, static counter: " + staticCounter);
    }
    
    /**
     * Prints summary of static keyword concepts
     */
    public static void printSummary() {
        out.println("STATIC KEYWORD CONCEPTS SUMMARY:");
        out.println("1. Static Variables: Belong to class, shared among all instances");
        out.println("2. Static Methods: Can be called without object, cannot access instance members");
        out.println("3. Static Blocks: Execute when class is loaded, used for initialization");
        out.println("4. Static Nested Classes: Don't need outer class instance");
        out.println("5. Static Imports: Allow using static members without class name");
        out.println("6. Memory: Stored in Method Area, loaded at class loading time");
        out.println("7. Use Cases: Utility methods, constants, singleton pattern, counters");
        out.println("8. Best Practices: Use for utility methods, constants, avoid for state");
    }
}

// ========== 10. ADDITIONAL EXAMPLES ==========

/**
 * Class demonstrating static initialization order
 */
class StaticInitializationOrder {
    static {
        out.println("First static block of StaticInitializationOrder");
    }
    
    private static String staticVar = initializeStaticVar();
    
    private static String initializeStaticVar() {
        out.println("Static variable initialization method");
        return "Initialized";
    }
    
    static {
        out.println("Second static block of StaticInitializationOrder");
    }
    
    public StaticInitializationOrder() {
        out.println("Constructor of StaticInitializationOrder");
    }
}

/**
 * Class demonstrating static method overloading
 */
class StaticMethodOverloading {
    public static void display() {
        out.println("Static method with no parameters");
    }
    
    public static void display(String message) {
        out.println("Static method with String parameter: " + message);
    }
    
    public static void display(int number) {
        out.println("Static method with int parameter: " + number);
    }
    
    public static void display(String message, int number) {
        out.println("Static method with String and int parameters: " + message + ", " + number);
    }
}

/**
 * Class demonstrating static vs instance method hiding
 */
class Parent {
    public static void staticMethod() {
        out.println("Static method in Parent");
    }
    
    public void instanceMethod() {
        out.println("Instance method in Parent");
    }
}

class Child extends Parent {
    // This hides the parent's static method (not overriding)
    public static void staticMethod() {
        out.println("Static method in Child");
    }
    
    // This overrides the parent's instance method
    @Override
    public void instanceMethod() {
        out.println("Instance method in Child");
    }
} 