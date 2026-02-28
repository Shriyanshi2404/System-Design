package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor.CashWithdrawalProcessor;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor.FiveHundredWithdrawProcessor;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor.TwoHundredWithdrawProcessor;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor.TwoThousandWithdrawProcessor;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.Card;

public class CashWithdrawalState extends ATMState {


    public CashWithdrawalState()
    {
        System.out.println("Please enter the withdrawal ammount");
    }


    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmmount)
    {
        System.out.println("User entered withdrawal amount: " + withdrawalAmmount);

        if(atm.getAtmBalance() < withdrawalAmmount)
        {
            System.out.println("Insufficient fund in the ATM machine");
            exit(atm);
        }
        else if(card.getBankBalance() < withdrawalAmmount)
        {
            System.out.println("Insufficient fund in the User Bank Account");
            exit(atm);
        }
        else
        {
            card.deductBankBalance(withdrawalAmmount);
            atm.deductATMBalance(withdrawalAmmount);

            // Using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes, how many 200 Rs notes, etc has to be withdrawed
            CashWithdrawalProcessor cashWithdrawalProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new TwoHundredWithdrawProcessor(null)));

            cashWithdrawalProcessor.withdraw(atm, withdrawalAmmount);
            exit(atm);
        }
    }
    @Override
    public void exit(ATM atm)
    {
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exiting ATM");
        returnCard();
    }

    @Override
    public void returnCard()
    {
        System.out.println("Please collect your card");
    }
}
