package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context;

public class Card {
    int cvv;
    int expDate;
    int expMonth;
    int expYear;
    BankAccount account;
    static int pin = 121121;

    public Card()
    {}

    public void setCvv(int cvv)
    {
        this.cvv = cvv;
    }
    public void setExpDate(int expDate)
    {
        this.expDate = expDate;
    }
    public void setExpMonth(int expMonth)
    {
        this.expMonth = expMonth;
    }
    public void setExpYear(int expYear)
    {
        this.expYear = expYear;
    }
    public void setBankAccount(BankAccount account)
    {
        this.account = account;
    }
    // method to check the pin entered is correct or not -- used in HasCadState authenticatePin()
    public boolean isCorrectPinEntered(int pinNumber)
    {
        if(pin == pinNumber)
            return true;
        return false;
    }

    public int getBankBalance()
    {
        return account.getBalance();
    }

    public void deductBankBalance(int amount){
        account.withdrawalBalance(amount);
    }
}

