package LLD_Concepts.Observer_Design_Pattern.Observable;

import LLD_Concepts.Observer_Design_Pattern.Observer.NotifactionAlertObserver;

public interface StockObservable {

    public void addItem(NotifactionAlertObserver observer);
    public void removeItem(NotifactionAlertObserver observer);
    public void setStockCount(int newStockCount);
    public int getStockCount();
    public void notifyObservers();
}
