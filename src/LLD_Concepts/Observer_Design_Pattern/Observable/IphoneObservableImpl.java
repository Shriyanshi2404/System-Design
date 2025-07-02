package LLD_Concepts.Observer_Design_Pattern.Observable;

import LLD_Concepts.Observer_Design_Pattern.Observer.NotifactionAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    int stockCount;
    List<NotifactionAlertObserver> observerList = new ArrayList<>();

    public IphoneObservableImpl(int initialStockCount) {
        this.stockCount = initialStockCount;
    }

    @Override
    public void addItem(NotifactionAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeItem(NotifactionAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (NotifactionAlertObserver observer : observerList) {
            // Notify each observer about the stock update
            // This could be a method call on the observer, e.g., observer.update(stockCount);
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount == 0)
        {
            notifyObservers();
        }
        stockCount += newStockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }


}
