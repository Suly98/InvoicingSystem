package InvoiceSystem;

import java.util.*;

public class MainMenu {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Integer word;
        do {
            System.out.println("           Application Main Menu:       ");
            System.out.println("1-Shop Settings");
            System.out.println("2-Manage Shop Items");
            System.out.println("3-Create New Invoice");
            System.out.println("4-Report: Statistics");
            System.out.println("5-Report: All Invoices");
            System.out.println("6-Search Invoices");
            System.out.println("7-Program Statistics");
            System.out.println("8-Exit");
            System.out.print("Enter your option: ");
            word = sc.nextInt();
            if (word == 1) {
                shopSettings();
            } else if (word == 2) {
                manageShopItems();
            } else if (word == 3) {
                //createNewInvoice();
            } else if (word == 4) {
                //reportStatistics();
            } else if (word == 5) {
                //reportAllInvoices();
            } else if (word == 6) {
                //searchInvoices();
            } else if (word == 7) {
               // programStatistics();
            }
        } while (word != 8);
    }

    public static void shopSettings(){
        int word;
        do {
            System.out.println("            Shop Settings:      ");
            System.out.println("1-Load Data (Items and invoices)");
            System.out.println("2-Set Shop Name (data should be saved)");
            System.out.println("3-Set Invoice Header (Tel / Fax / Email / Website)");
            System.out.println("4-Go Back");
            System.out.print("Enter your option: ");
            word = sc.nextInt();
            if (word == 1) {
                loadData();
            } else if (word == 2) {
                //setShopName();
            } else if (word == 3) {
                //setInvoiceHeader();
            }
        } while (word != 4);
    }
    public static void loadData(){
        Item.loadItems();

    }

    public static void manageShopItems() {

    }

}
