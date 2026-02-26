package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context;

public class ItemShelf {
    int code;
    boolean soldOut;
    Item item;

    public int getCode()
    {
        return code;
    }

    public boolean isSoldOut()
    {
        return soldOut;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public void setSoldOut(boolean value)
    {
        this.soldOut = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
