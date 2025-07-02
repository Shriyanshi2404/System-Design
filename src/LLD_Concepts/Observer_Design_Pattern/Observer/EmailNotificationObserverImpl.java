package LLD_Concepts.Observer_Design_Pattern.Observer;

import LLD_Concepts.Observer_Design_Pattern.Observable.StockObservable;

public class EmailNotificationObserverImpl implements NotifactionAlertObserver {

    String emailId;
    StockObservable observable;

    public EmailNotificationObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmailNotification("Product is back in stock", emailId);
    }

    private void sendEmailNotification(String message, String emailId) {
        // Logic to send email notification
        System.out.println("Email notification sent to " + emailId + ": " + message);
    }
}
