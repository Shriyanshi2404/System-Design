package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.BadCode;

class SMSService {
    public void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}