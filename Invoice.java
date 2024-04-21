package InvoiceSystem;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Invoice {

    Integer id;
    Item item;
    Date date;
    Customer customer;
    String header;
    Integer NoOfItems;
    Float totalAmount;
    Float paidAmount;
    Float balance;
    List<Invoice> invoices;

    //to add invoices
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public void loadInvoices(){
        System.out.println(invoices.toString());
    }

    public Item getItem() {
        return item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getNoOfItems() {
        return NoOfItems;
    }

    public void setNoOfItems(Integer noOfItems) {
        NoOfItems = noOfItems;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) && Objects.equals(date, invoice.date) && Objects.equals(NoOfItems, invoice.NoOfItems) && Objects.equals(totalAmount, invoice.totalAmount) && Objects.equals(paidAmount, invoice.paidAmount) && Objects.equals(balance, invoice.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, NoOfItems, totalAmount, paidAmount, balance);

    }

    @Override
    public String toString() {
        return "Invoice{" +
                "item=" + item +
                ", date=" + date +
                ", customer=" + customer +
                ", header='" + header + '\'' +
                ", NoOfItems=" + NoOfItems +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                ", invoices=" + invoices +
                '}';
    }
}

