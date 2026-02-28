package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;

public class TwoHundredWithdrawProcessor extends CashWithdrawalProcessor {

    public TwoHundredWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor)
    {
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int amount)
    {
        int required = amount/200;
        int balance = amount%200;

        if(required <= atm.getNoOfTwoHundredNotes())
        {
            atm.deductTwoHundredNotes(required);
        }
        else if(required > atm.getNoOfTwoHundredNotes())
        {
            int noOfNotesCanBeDeducted = atm.getNoOfTwoHundredNotes();
            atm.deductTwoHundredNotes(noOfNotesCanBeDeducted);
            balance = balance + (required-noOfNotesCanBeDeducted) * 500;
        }
        if(balance != 0)
            super.withdraw(atm, balance);
    }
}
