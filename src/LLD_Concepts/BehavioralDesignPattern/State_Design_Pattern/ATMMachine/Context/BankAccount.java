package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context;

public class BankAccount {
    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }

    public void setBalance(int amount)
    {
        this.balance = amount;
    }
    public int getBalance()
    {
        return this.balance;
    }
}
