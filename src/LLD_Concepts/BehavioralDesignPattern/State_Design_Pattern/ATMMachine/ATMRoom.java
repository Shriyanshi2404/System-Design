package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine;

import LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context.*;

public class ATMRoom {

    ATM atm;
    User user;

    public static void main(String[] args)
    {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 121121);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize()
    {
        // create ATM
        this.atm = ATM.getAtmObject();
        atm.setAmtBalance(3500, 1, 2, 5);

        // create USER
        this.user = createUser();
    }

    private User createUser()
    {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard()
    {
        Card card = new Card();
        card.setExpDate(24);
        card.setExpMonth(9);
        card.setExpYear(2030);
        card.setCvv(123);
        card.setBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(3000);
        return bankAccount;
    }
}