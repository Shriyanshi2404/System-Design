package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.AmountWithdrawalProcessor;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.ATM;

public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount)
    {
        if(nextCashWithdrawalProcessor != null)
        {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}
