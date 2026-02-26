package LLD_Concepts.BehavioralDesignPattern.State_Design_Pattern.VendingMachine.Context;

public class Item {
    int price;
    ItemType type;

    public ItemType getType()
    {
        return type;
    }

    public int getPrice()
    {
        return price;
    }
    public void setType(ItemType itemType)
    {
        this.type = itemType;
    }

    public void setPrice(int cost)
    {
        this.price = cost;
    }
}
