package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.implementation;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.Coin;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.Item;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.State;

public class SelectionState extends State {

    public SelectionState()
    {
        System.out.println("Vending machine is in Selection state");
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception
    {
        System.out.println("Selecting the item whose codeNumber is : " + codeNumber);

        //1. get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        //2. total amount paid by User
        int paidByUser = 0;
        for(Coin coin : machine.getCoinList())
            paidByUser += coin.value;

        //3. compare product price and amount paid by user
        if(item.getPrice() > paidByUser)
        {
            System.out.println("Insufficient balance");
            refundAllMoney(machine);
            throw new Exception("Insufficient amount paid by user");
        }
        else if(item.getPrice() <= paidByUser)
        {
            if(paidByUser > item.getPrice()) {
                System.out.println("Price paid by user is more, so need to return the remaining balance back to user");
                int returnExtraMoney = paidByUser - item.getPrice();
                getChange(returnExtraMoney);
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception
    {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }
}
