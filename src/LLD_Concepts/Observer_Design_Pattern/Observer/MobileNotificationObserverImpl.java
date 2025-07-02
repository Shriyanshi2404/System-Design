package LLD_Concepts.Observer_Design_Pattern.Observer;

import LLD_Concepts.Observer_Design_Pattern.Observable.StockObservable;


public class MobileNotificationObserverImpl implements NotifactionAlertObserver {

    String userName;
    StockObservable observable;

    public MobileNotificationObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMobileNotification("Product is back in stock", userName);
    }

    private void sendMobileNotification(String message, String userName) {
        // Logic to send mobile notification
        System.out.println("Mobile notification sent to " + userName + ": " + message);
    }
}
