package LLD_Concepts.Solid_Principles.Open_Closed_Principle;

public class FileInvoiceDao implements InvoiceDao{
    Invoice invoice;

    public FileInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        System.out.println("Save invoice to File whose total is : " + invoice.calculateTotalPrice());
    }
}
