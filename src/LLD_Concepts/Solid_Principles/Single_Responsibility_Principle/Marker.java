package LLD_Concepts.Solid_Principles.Single_Responsibility_Principle;

/**
 * Single Responsibility Principle (SRP)
 * A class should have only one reason to change, meaning it should only have one job or responsibility.
 * Example: Invoice class handles the calculation of the total price of marker but does not handle to print the invoice or save to DB.
 * Similarly, InvoicePrint class is responsible for printing the invoice and SaveInvoice class is responsible for saving the invoice to a database.
 * So every class has a single responsibility.
 */

// this class is responsible for creating a marker with its properties
public class Marker {
    String color;
    String name;
    int price;
    int yearOfManufacture;

    public Marker(String color, String name, int price, int yearOfManufacture) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
    }

  // here this class is responsible for creating an invoice by calculating the total price based on the marker and quantity
  static class Invoice {
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

  // here this class is responsible for printing the invoice
  static class InvoicePrint {
      Invoice invoice;

      public InvoicePrint(Invoice invoice){
          this.invoice = invoice;
      }

      public void printInvoice() {
          Marker marker = invoice.marker;
          System.out.println("Marker Name: " + marker.name);
          System.out.println("Color: " + marker.color);
          System.out.println("Price per Marker: " + marker.price);
          System.out.println("Quantity: " + invoice.quantity);
          System.out.println("Total Price: " + invoice.calculateTotalPrice());
      }
  }

  // here this class is responsible for saving the invoice to a database
  static class SaveInvoice {
      Invoice invoice;

      public SaveInvoice(Invoice invoice) {
          this.invoice = invoice;
      }
      public void saveToDB() {
          // Logic to save the invoice to a database or file
          System.out.println("Invoice saved for marker: " + invoice.marker.name);
      }
  }

  public static void main(String[] args) {
      Marker marker = new Marker("Red", "Sharpie", 10, 2023);
      Invoice invoice = new Invoice(marker, 5);
      InvoicePrint invoicePrint = new InvoicePrint(invoice);
      SaveInvoice saveInvoice = new SaveInvoice(invoice);

      invoicePrint.printInvoice();
      saveInvoice.saveToDB();
  }
}
