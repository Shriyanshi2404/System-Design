package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.GoodCode;

public class NotificationService {
    private NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel channel){
        this.notificationChannel = channel;
    }

    public void notify(String msg){
        notificationChannel.send(msg);
    }
}
