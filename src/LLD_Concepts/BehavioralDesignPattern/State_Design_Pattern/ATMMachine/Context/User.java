package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.ATMMachine.Context;

public class User {
    Card card;
    BankAccount account;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
