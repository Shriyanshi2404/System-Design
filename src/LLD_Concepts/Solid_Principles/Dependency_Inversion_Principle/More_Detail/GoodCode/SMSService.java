package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.GoodCode;

public class SMSService implements NotificationChannel{
    @Override
    public void send(String msg) {
        System.out.println("Sending SMS " + msg);
    }
}
