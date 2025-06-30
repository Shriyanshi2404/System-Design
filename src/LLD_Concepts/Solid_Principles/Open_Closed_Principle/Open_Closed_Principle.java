package LLD_Concepts.Solid_Principles.Open_Closed_Principle;

/**
 * Open/Closed Principle (OCP)
 * Software entities (classes, modules, functions, etc.) should be OPEN for extension but CLOSED for modification.
 * This means that the behavior of a module can be extended without modifying its source code.
 * Example: InvoiceDao interface allows different implementations to save invoices in Database and in file separately without changing the interface itself.
 */

public class Open_Closed_Principle {

    public static void main(String[] args) {


        Marker marker = new Marker("Blue", "Pilot", 15, 2022);
        Invoice invoice = new Invoice(marker, 5);

        // Example usage of InvoiceDao implementations
        InvoiceDao fileInvoiceDao = new FileInvoiceDao(invoice);
        InvoiceDao databaseInvoiceDao = new DatabaseInvoiceDao(invoice);

        fileInvoiceDao.saveInvoice(invoice);
        databaseInvoiceDao.saveInvoice(invoice);
    }
}
