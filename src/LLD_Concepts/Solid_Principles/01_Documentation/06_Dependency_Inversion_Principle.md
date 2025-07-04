# Dependency Inversion Principle (DIP)

## Definition

**"High-level modules should not depend on low-level modules. Both should depend on abstractions."**

**High-order classes should not be tightly coupled to lower-level classes. Rather, they should depend upon interfaces (abstractions).**

This means:
1. **High-level modules** (classes that contain business logic) should not depend directly on **low-level modules** (classes that handle specific implementations)
2. Both should depend on **abstractions** (interfaces or abstract classes)

## Why is DIP Important?

- **Reduces coupling** between classes
- **Increases flexibility** - easy to change implementations
- **Improves testability** - easy to mock dependencies
- **Supports extensibility** - new implementations can be added without changing existing code

## Example: Notification Service

### ❌ Bad Code (Violates DIP)

```java
// Low-level modules (concrete implementations)
public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService {
    public void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module depending on low-level modules
public class NotificationService {
    private EmailService emailService;
    private SMSService smsService;

    public NotificationService(){
        this.emailService = new EmailService();  // Direct dependency
        this.smsService = new SMSService();      // Direct dependency
    }

    public void notifyByEmail(String msg){
        emailService.sendEmail(msg);
    }
    
    public void notifyBySMS(String msg){
        smsService.sendSMS(msg);
    }
}
```

**Problems with this approach:**
- `NotificationService` is **tightly coupled** to `EmailService` and `SMSService`
- **Hard to test** - can't easily mock dependencies
- **Hard to extend** - adding new notification types requires modifying `NotificationService`
- **Violates DIP** - high-level module depends on low-level modules

### ✅ Good Code (Follows DIP)

```java
// Abstraction (Interface)
public interface NotificationChannel {
    void send(String msg);
}

// Low-level modules implementing the abstraction
public class EmailService implements NotificationChannel {
    @Override
    public void send(String msg) {
        System.out.println("Sending Email " + msg);
    }
}

public class SMSService implements NotificationChannel {
    @Override
    public void send(String msg) {
        System.out.println("Sending SMS " + msg);
    }
}

// High-level module depending on abstraction
public class NotificationService {
    private NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel channel){
        this.notificationChannel = channel;  // Dependency injection through constructor while creating the instance
    }

    public void notify(String msg){
        notificationChannel.send(msg);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        NotificationService emailNotification = new NotificationService(new EmailService());
        emailNotification.notify("Your order has been shipped");

        NotificationService smsNotification = new NotificationService(new SMSService());
        smsNotification.notify("OTP 1234");
    }
}
```

**Benefits of this approach:**
- `NotificationService` depends on `NotificationChannel` interface (abstraction)
- **Loose coupling** - can easily swap implementations
- **Easy to test** - can mock `NotificationChannel`
- **Easy to extend** - new notification types can be added without changing `NotificationService`
- **Follows DIP** - high-level module depends on abstraction

## Key Concepts

### 1. Dependency Injection
Instead of creating dependencies inside the class, inject them through:
- **Constructor injection** (recommended)
- Setter injection
- Interface injection

### 2. Inversion of Control (IoC)
The control of creating and managing dependencies is **inverted** from the class that uses them to an external entity.

### 3. High-level vs Low-level Modules
- **High-level modules**: Contain business logic and policies
- **Low-level modules**: Handle specific implementations and details

## Benefits of DIP

1. **Flexibility**: Easy to change implementations without modifying existing code
2. **Testability**: Easy to mock dependencies for unit testing
3. **Maintainability**: Reduces coupling between classes
4. **Extensibility**: New implementations can be added easily
5. **Reusability**: Components can be reused in different contexts

## Common Violations

1. **Direct instantiation**: Creating dependencies using `new` keyword inside the class
2. **Concrete dependencies**: Depending on concrete classes instead of abstractions
3. **Static dependencies**: Using static method calls that can't be easily mocked

## Best Practices

1. **Depend on abstractions** (interfaces/abstract classes) not concrete implementations
2. **Use dependency injection** to provide dependencies
3. **Create abstractions** that represent what you need, not what you have
4. **Keep abstractions stable** - don't change them frequently
5. **Use IoC containers** in larger applications to manage dependencies

## Summary

The Dependency Inversion Principle helps create more flexible, testable, and maintainable code by:
- Making high-level modules independent of low-level implementation details
- Using abstractions to define contracts between modules
- Allowing easy substitution of implementations
- Reducing coupling and increasing cohesion

Remember: **"Depend on abstractions, not concretions!"**
