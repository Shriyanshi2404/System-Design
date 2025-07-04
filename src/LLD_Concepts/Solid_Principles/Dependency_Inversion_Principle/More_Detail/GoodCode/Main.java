package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.GoodCode;


public class Main {
    public static void main(String[] args) {
        NotificationService emailNotification = new NotificationService(new EmailService());
        emailNotification.notify("Your order has been shipped");

        NotificationService smsNotification = new NotificationService(new SMSService());
        smsNotification.notify("OTP 1234");
    }
}
