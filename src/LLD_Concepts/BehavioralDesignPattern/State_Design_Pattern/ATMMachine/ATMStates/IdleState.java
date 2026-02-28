package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card)
    {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
