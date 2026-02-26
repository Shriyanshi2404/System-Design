package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.implementation;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.Item;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.State;

public class DispenseState extends State {

    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Vending machine is in Dispense state");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Item with codeNumber : " + codeNumber + " is ready to be dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }
}
