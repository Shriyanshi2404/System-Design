package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor)
    {
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int amount)
    {
        int required = amount/500;
        int balance = amount%500;

        if(required <= atm.getNoOfFiveHundredNotes())
        {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes())
        {
            int noOfNotesCanBeDeducted = atm.getNoOfFiveHundredNotes();
            atm.deductFiveHundredNotes(noOfNotesCanBeDeducted);
            balance = balance + (required-noOfNotesCanBeDeducted) * 500;
        }
        if(balance != 0)
            super.withdraw(atm, balance);
    }
}
