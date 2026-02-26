package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.Item;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.ItemShelf;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.ItemType;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context.VendingMachine;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.Coin;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.VendingMachineStates.State;

public class VendingMachineAppDemo {

    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("| filling up the inventory |");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("| clicking on InsertCoinButton |");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            System.out.println("| Inserting coin |");
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            System.out.println("Coins are inserted, current balance: " + vendingMachine.getCoinList().stream().mapToInt(coin -> coin.value).sum());

            System.out.println("| clicking on ProductSelectionButton |");
            vendingState.clickOnSelectProductButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            System.out.println("| Selecting the product |");
            vendingState.selectProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] itemShelves = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < itemShelves.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            itemShelves[i].setItem(newItem);
            itemShelves[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }

}

