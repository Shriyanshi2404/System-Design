package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.implementation;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.Item;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.State;

import java.util.ArrayList;

public class IdleState extends State {

    public IdleState()
    {
        System.out.println("Vending machine is in Idle state");
    }

    public IdleState(VendingMachine machine)
    {
        System.out.println("Vending machine is in Idle state");
        machine.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception
    {
        System.out.println("Clicking on insert coin button");
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        System.out.println("Action: Update the inventory");
        machine.getInventory().addItem(item, codeNumber);
    }
}
