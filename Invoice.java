package InvoiceSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static InvoiceSystem.MainMenu.items;

public class Invoice {

    Integer id;
    Item item;
    Date date;
    Customer fullName;
    String header;
    Integer NoOfItems;
    Double totalAmount;
    Double paidAmount;
    Double balance;
    List<Invoice> invoices = new ArrayList<>();


//    public Invoice(Date date, Customer fullName,
//                   String header, Integer noOfItems,
//                   Double totalAmount, Double paidAmount,
//                   Double balance) {
//        this.date = date;
//        this.fullName = fullName;
//        this.header = header;
//        NoOfItems = noOfItems;
//        this.totalAmount = totalAmount;
//        this.paidAmount = paidAmount;
//        this.balance = balance;
//    }

    /*-------------fUNCTIONS------------*/
    //to add invoices
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    //to print invoices
    public void printInvoice() {
        System.out.println("Invoice No: " + generateId());
        System.out.println("Invoice header:  " + header);
        System.out.println("Shop name:  " + MainMenu.setShopName());
        System.out.println("Invoice Date: " + date);
        System.out.println("Customer Name: " + fullName);
        System.out.println("Items:" + getItem());
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Total amount : " + total());
        System.out.println("The Balanced left" + balance);

    }


    //the total of the items amount!
    public double total() {
        double total = 0;
        total += item.getPrice() * item.getQuantity();

        return total;
    }


    //To auto add the invoices id and incrementing them one by one:
    public static Integer nextId= 1;

    public static Integer generateId(){
        return nextId++;
    }

    public Item getItem() {
        for(Item item: items){
            item.print();
        }
        return item;
    }

    public Customer getFullName() {
        return fullName;
    }

    public void setFullName(Customer fullName) {
        this.fullName = fullName;
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
        noOfItems += item.getQuantity();
        NoOfItems = noOfItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
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
        balance = getPaidAmount() - getTotalAmount();
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
                "item=" + item +
                ", date=" + date +
                ", customer=" + fullName +
                ", header='" + header + '\'' +
                ", NoOfItems=" + NoOfItems +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                ", invoices=" + invoices +
                '}';
    }
}

