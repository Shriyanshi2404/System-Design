package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.ATMStates;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.Card;
import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.TransactionType;

import static LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.TransactionType.BALANCE_CHECK;
import static LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.TransactionType.CASH_WITHDRAWAL;

public class SelectOperationState extends ATMState {

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        switch (txnType) {
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atm)
    {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exiting the ATM due to invalid operation selected by user");
    }

    @Override
    public void returnCard()
    {
        System.out.println("Please collect your card");
    }

    private void showOperations()
    {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
