package LLD_Concepts.Observer_Design_Pattern.Observable;

import LLD_Concepts.Observer_Design_Pattern.Observer.NotifactionAlertObserver;

/**
 * StockObservable interface defines the methods for managing stock items
 * and notifying observers when stock changes.
 */
public interface StockObservable {

    public void addItem(NotifactionAlertObserver observer);
    public void removeItem(NotifactionAlertObserver observer);
    public void setStockCount(int newStockCount);
    public int getStockCount();
    public void notifyObservers();
}
