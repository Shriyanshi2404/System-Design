# Single Responsibility Principle (SRP)

## Definition
**"A class should have only one reason to change, meaning it should only have one job or responsibility."**

## What does this mean?
- **One Job**: Each class should do one thing and do it well
- **One Reason to Change**: A class should only be modified when its specific responsibility needs to change

Think of it like a kitchen where each person has one job - the chef cooks, the waiter serves, and the cashier handles payments. Everyone focuses on their specialty!

## Why is this important?
- **Easier to understand**: Classes with single responsibilities are simple to read and understand
- **Easier to test**: Testing one responsibility is much simpler than testing multiple
- **Easier to maintain**: Changes to one responsibility don't affect others
- **Better code organization**: Each class has a clear, specific purpose
- **Reduces bugs**: Fewer responsibilities mean fewer things that can go wrong

---

## ❌ Bad Example (Violates SRP)

```java
public class Invoice {
    Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Responsibility 1: Calculate total price
    public int calculateTotalPrice() {
        return marker.price * quantity;
    }

    // Responsibility 2: Print invoice (VIOLATION!)
    public void printInvoice() {
        System.out.println("Marker Name: " + marker.name);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    // Responsibility 3: Save to database (VIOLATION!)
    public void saveToDB() {
        // Logic to save the invoice to database
        System.out.println("Invoice saved to database");
    }
}
```

### Problems with this approach:
1. **Too many responsibilities**: The Invoice class handles calculation, printing, AND database operations
2. **Hard to maintain**: Changes to printing logic require modifying the Invoice class
3. **Hard to test**: Must test all three responsibilities together
4. **Violates SRP**: Multiple reasons to change this class (calculation logic, printing format, database schema)

---

## ✅ Good Example (Follows SRP)

### Step 1: Marker Class (One Responsibility - Store Marker Properties)
```java
public class Marker {
    String color;
    String name;
    int price;
    int yearOfManufacture;

    public Marker(String color, String name, int price, int yearOfManufacture) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
    }
}
```

### Step 2: Invoice Class (One Responsibility - Calculate Total Price)
```java
public class Invoice {
    Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotalPrice() {
        return marker.price * quantity;
    }
}
```

### Step 3: InvoicePrint Class (One Responsibility - Print Invoice)
```java
public class InvoicePrint {
    Invoice invoice;

    public InvoicePrint(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        Marker marker = invoice.marker;
        System.out.println("Marker Name: " + marker.name);
        System.out.println("Color: " + marker.color);
        System.out.println("Price per Marker: " + marker.price);
        System.out.println("Quantity: " + invoice.quantity);
        System.out.println("Total Price: " + invoice.calculateTotalPrice());
    }
}
```

### Step 4: SaveInvoice Class (One Responsibility - Save to Database)
```java
public class SaveInvoice {
    Invoice invoice;

    public SaveInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // Logic to save the invoice to a database
        System.out.println("Invoice saved for marker: " + invoice.marker.name);
    }
}
```

### Benefits of this approach:
1. **Clear responsibilities**: Each class has one specific job
2. **Easy to modify**: Need to change printing format? Only modify `InvoicePrint`
3. **Easy to test**: Each class can be tested independently
4. **Reusable**: `Invoice` can be used with different printing or saving strategies
5. **Maintainable**: Changes to one responsibility don't affect others

---

## Usage Example

```java
public class Main {
    public static void main(String[] args) {
        // Create a marker
        Marker marker = new Marker("Red", "Sharpie", 10, 2023);
        
        // Create an invoice
        Invoice invoice = new Invoice(marker, 5);
        
        // Print the invoice
        InvoicePrint invoicePrint = new InvoicePrint(invoice);
        invoicePrint.printInvoice();
        
        // Save the invoice
        SaveInvoice saveInvoice = new SaveInvoice(invoice);
        saveInvoice.saveToDB();
    }
}
```

---

## How to Identify SRP Violations

### Red Flags:
1. **Class names with "And"**: `UserManagerAndValidator` suggests multiple responsibilities
2. **Long methods**: If a method does many things, it probably violates SRP
3. **Many imports**: Lots of imports might indicate the class is doing too much
4. **Hard to name**: If you can't easily describe what a class does, it might be doing too much
5. **Frequent changes**: If you're always modifying the same class for different reasons

### Ask yourself:
- "What is this class responsible for?"
- "How many different reasons would I have to change this class?"
- "Can I describe this class's purpose in one sentence?"

---

## Common Examples of SRP

### ✅ Good SRP Examples:
- **User**: Stores user information
- **UserValidator**: Validates user data
- **UserRepository**: Handles database operations for users
- **EmailService**: Sends emails
- **Logger**: Logs application events

### ❌ Bad SRP Examples:
- **UserManager**: Manages users, validates data, sends emails, logs activities
- **FileProcessor**: Reads files, processes data, sends notifications, updates database
- **OrderHandler**: Creates orders, calculates prices, sends emails, updates inventory

---

## Key Takeaways

1. **One class = One responsibility**
2. **Separate concerns**: Don't mix business logic with presentation or data access
3. **Think about change**: Classes should change for only one reason
4. **Keep it simple**: If you can't explain what a class does in one sentence, it's probably doing too much
5. **Test each responsibility separately**: Each class should be easily testable in isolation

## Real-world Applications
- **MVC Architecture**: Models, Views, and Controllers each have distinct responsibilities
- **Microservices**: Each service handles one business capability
- **Database design**: Each table represents one entity type
- **API design**: Each endpoint handles one specific operation

---

*Remember: A class should be like a good employee - it should have one clear job and do it really well!*
