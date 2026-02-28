package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.Card;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card)
    {
        System.out.println("OOPS Something went wrong");
    }
    public void authenticatePin(ATM atm, Card card, int pin)
    {
        System.out.println("OOPS Something went wrong");
    }

    public void returnCard()
    {
        System.out.println("OOPS Something went wrong");
    }

    public void exit(ATM atm)
    {
        System.out.println("OOPS Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        System.out.println("OOPS Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmmount)
    {
        System.out.println("OOPS Something went wrong");
    }

    public void displayBalance(ATM atm, Card card)
    {
        System.out.println("OOPS Something went wrong");
    }
}
