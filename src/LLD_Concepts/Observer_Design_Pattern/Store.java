package LLD_Concepts.Observer_Design_Pattern;

import LLD_Concepts.Observer_Design_Pattern.Observable.IphoneObservableImpl;
import LLD_Concepts.Observer_Design_Pattern.Observable.StockObservable;
import LLD_Concepts.Observer_Design_Pattern.Observer.EmailNotificationObserverImpl;
import LLD_Concepts.Observer_Design_Pattern.Observer.MobileNotificationObserverImpl;
import LLD_Concepts.Observer_Design_Pattern.Observer.NotifactionAlertObserver;
import jdk.jfr.Configuration;

import javax.swing.ImageIcon;
public class Store {

    public static void main(String[] args) {

        Store store = new Store();
        ImageIcon imageIcon = new ImageIcon("src/resources/ObserverDesignPattern.png");

        // Display the image icon (this is just a placeholder, actual GUI code would be needed to show it)
        System.out.println("Store image icon: " + imageIcon.getDescription());


        // Create a instance of StockObservable and NotificationAlertObservers
        StockObservable iphoneStockObservable = new IphoneObservableImpl(0);

        NotifactionAlertObserver observer1 = new EmailNotificationObserverImpl("abc@gmail.com", iphoneStockObservable);
        NotifactionAlertObserver observer2 = new MobileNotificationObserverImpl("simran24", iphoneStockObservable);
        NotifactionAlertObserver observer3 = new EmailNotificationObserverImpl("xyz@gmail.com", iphoneStockObservable);

        iphoneStockObservable.addItem(observer1);
        iphoneStockObservable.addItem(observer2);
        iphoneStockObservable.addItem(observer3);

        // Simulate stock updates
        iphoneStockObservable.setStockCount(10); // This should trigger notifications to observers
        iphoneStockObservable.setStockCount(5);  // This should also trigger notifications to observers
        iphoneStockObservable.setStockCount(0);
        System.out.println("Current stock count is : " + iphoneStockObservable.getStockCount());// This should trigger notifications to observers
    }

}
