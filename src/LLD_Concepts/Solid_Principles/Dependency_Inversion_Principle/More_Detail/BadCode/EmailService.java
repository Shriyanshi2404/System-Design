package LLD_Concepts.Solid_Principles.Dependency_Inversion_Principle.More_Detail.BadCode;

public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
