package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates.ATMState;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates.IdleState;

public class ATM {
    private static final ATM atmObject = new ATM();

    ATMState currentATMState;
    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfTwoHundredNotes;

    private ATM()
    {
        currentATMState = new IdleState();
    }

    public static ATM getAtmObject() {
        return atmObject;
    }

    public void setCurrentATMState(ATMState currentATMState)
    {
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState()
    {
        return this.currentATMState;
    }

    public void setAmtBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfTwoHundredNotes)
    {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoHundredNotes = noOfTwoHundredNotes;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public int getNoOfTwoThousandNotes()
    {
        return this.noOfTwoThousandNotes;
    }
    public int getNoOfFiveHundredNotes()
    {
        return this.noOfFiveHundredNotes;
    }
    public int getNoOfTwoHundredNotes()
    {
        return this.noOfTwoHundredNotes;
    }

    public void deductTwoThousandNotes(int requiredNotes)
    {
        noOfTwoThousandNotes = noOfTwoThousandNotes - requiredNotes;
    }

    public void deductFiveHundredNotes(int requiredNotes)
    {
        noOfFiveHundredNotes = noOfFiveHundredNotes - requiredNotes;
    }

    public void deductTwoHundredNotes(int requiredNotes)
    {
        noOfTwoHundredNotes = noOfTwoHundredNotes - requiredNotes;
    }


    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("200Notes: " + noOfTwoHundredNotes);
    }
}
