package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.Card;

public class HasCardState extends ATMState {

    @Override
    public void authenticatePin(ATM atm, Card card, int pin)
    {
        System.out.println("Authenticating the pin");
        boolean isCorrectPinEntered = card.isCorrectPinEntered(pin);

        if(isCorrectPinEntered)
        {
            atm.setCurrentATMState(new SelectOperationState());
        }
        else
        {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm)
    {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happened because of invalid pin number");
    }

    @Override
    public void returnCard()
    {
        System.out.println("Please collect your card");
    }
}
