package LLD_Concepts.Solid_Principles.Open_Closed_Principle;

public class DatabaseInvoiceDao implements InvoiceDao{

    Invoice invoice;

    public DatabaseInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        System.out.println("Save invoice to Database whose total is : " + invoice.calculateTotalPrice());
    }
}
