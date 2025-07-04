package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.BadCode;

public class NotificationService {
    private EmailService emailService;
    private SMSService smsService;

    public NotificationService(){
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    public void notifyByEmail(String msg){
        emailService.sendEmail(msg);
    }
    public void notifyBySMS(String msg){
        smsService.sendSMS(msg);
    }
}
