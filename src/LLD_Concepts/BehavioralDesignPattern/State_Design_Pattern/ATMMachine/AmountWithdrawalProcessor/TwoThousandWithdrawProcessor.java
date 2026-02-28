package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawalProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor)
    {
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int amount)
    {
        int required = amount/2000;
        int balance = amount%2000;

        if(required <= atm.getNoOfTwoThousandNotes())
        {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes())
        {
            int noOfNotesCanBeDeducted = atm.getNoOfTwoThousandNotes();
            atm.deductTwoThousandNotes(noOfNotesCanBeDeducted);
            balance = balance + (required-noOfNotesCanBeDeducted) * 2000;
        }
        if(balance != 0)
            super.withdraw(atm, balance);
    }

}
