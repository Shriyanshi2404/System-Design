package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.implementation;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.Coin;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.State;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState extends State {

    public HasMoneyState()
    {
        System.out.println("Vending machine is in Has money state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin)
    {
        machine.getCoinList().add(coin);
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine)
    {
        System.out.println("Clicking on select product button");
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public List<Coin> refundAllMoney(VendingMachine machine)
    {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }
}
