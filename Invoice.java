package InvoiceSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Invoice {

    //To auto add the invoices id and incrementing them one by one:
    public static Integer nextId = 1;

    //Attributes
    Integer id;
    List<Item> items;
    String date;
    Customer customer;
    String header;
    Integer NoOfItems;
    Double totalAmount;
    Double paidAmount;
    Double balance;
    List<Invoice> invoices = new ArrayList<>();


    public static Integer generateId() {
        return nextId++;
    }

    // calculate the total amount
    public static double calculateTotalAmount(List<Item> items) {
        Double totalAmt = 0d;
        for (Item i : items) {
            for (int j = 1; j <= i.getQuantity(); j++) {
                totalAmt += i.getPrice().doubleValue();
            }
        }
        return totalAmt;
    }

    /*-------------fUNCTIONS------------*/
    //to add invoices
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    //to print invoices
    public void printInvoice() {
        System.out.println("Invoice No: " + generateId());
        System.out.println("Invoice header:  " + header);
        System.out.println("Shop name:  " + getShopName());
        System.out.println("Invoice Date: " + date);
        System.out.println("Customer Name: " + customer.fullName);
        System.out.println("Items:" + getItems());
        System.out.println("Paid Amount: " + getPaidAmount());
        System.out.println("Total amount : %.2d" + getTotalAmount());
        System.out.println("The Balanced left: " + getBalance());

    }

    public String getShopName() {
        String shopName = MainMenu.setShopName();
        return shopName;
    }

    public List<Item> getItems() {
        for (Item item : MainMenu.items) {
            item.print();
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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
        noOfItems += items.size();
        NoOfItems = noOfItems;
    }

    public Double getTotalAmount() {
        return Double.parseDouble(String.format("%.2f", totalAmount));
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getBalance() {
        if (getPaidAmount() > getTotalAmount()) {
            balance = getPaidAmount() - getTotalAmount();

        } else if (getTotalAmount() > getPaidAmount()) {
            Double leftAmount = getTotalAmount() - getPaidAmount();
            System.out.println("You have " + leftAmount + "left to Pay!!");

        }
        return balance;
    }

    public void setBalance(Double balance) {
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
                "item=" + items +
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

