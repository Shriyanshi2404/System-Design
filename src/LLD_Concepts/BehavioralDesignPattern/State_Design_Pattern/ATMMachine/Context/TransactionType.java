package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes(){

        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
