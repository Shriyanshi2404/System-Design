package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.Item;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;

import java.util.List;

public abstract class State {

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception
    {
        // by default nothing happens
    }
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception
    {
        // by default nothing happens
    }
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception
    {
        // by default nothing happens
    }
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception
    {
        // by default nothing happens
    }

    public int getChange(int returnChangeMoney) throws Exception
    {
        // by default nothing happens
        return 0;
    }

    public List<Coin> refundAllMoney(VendingMachine machine) throws Exception
    {
        // by default nothing happens
        return null;
    }

    public void updateInventory(VendingMachine machine, Item itemName, int codeNumber) throws Exception
    {
        // by default nothing happens
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception
    {
        // by default nothing happens
        return null;
    }
}
