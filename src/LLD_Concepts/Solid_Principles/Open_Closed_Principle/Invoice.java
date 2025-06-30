package LLD_Concepts.Solid_Principles.Open_Closed_Principle;

public class Invoice {
    Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotalPrice() {
        return marker.price * quantity;
    }
}
