package InvoiceSystem;

import com.sun.tools.javac.Main;

import java.util.*;

public class MainMenu {
    public static List<Item> items = new ArrayList<>();
    public static HashMap<Integer, Invoice> invoiceHashMap = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);
    public Integer itemsCounter;
    public Integer invoiceCounter;

    public static void main(String[] args) {
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
                createNewInvoice();
            } else if (word == 4) {
                reportStatistics();
            } else if (word == 5) {
                reportAllInvoices();
            } else if (word == 6) {
                searchInvoices();
            } else if (word == 7) {
                // programStatistics();
            }
        } while (word != 8);

    }

    public static void searchInvoices(){
        System.out.println("Enter the invoice number that you want to search: ");
        Integer invoiceNo = sc.nextInt();

        for(Invoice invoice: invoiceHashMap.values()){
            if(invoice.id == invoiceNo){
                invoice.printInvoice();
            }
        }
    }


    public static void createNewInvoice() {

        sc.nextLine();
        MainMenu.items.clear();
        System.out.println("Enter the invoice date (YY-MM-DD): ");
        String date = sc.nextLine();
        System.out.println("Enter the Customer name: ");
        String customerName = sc.nextLine();
        System.out.println("What is the amount Paid: ");
        Double amountPaid = sc.nextDouble();

        //Initilize a Custemer
        Customer customer = new Customer();
        customer.setFullName(customerName);


        //Creating an Invoice
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setHeader(setInvoiceHeader());
        invoice.setDate(date);
        invoice.setPaidAmount(amountPaid);
        invoice.setShopName(setShopName());


        addItems();


        invoice.setItems(MainMenu.items);

        invoice.setTotalAmount(Invoice.calculateTotalAmount(invoice.getItems()));

        //setting an id n adding invoice to the invoice map:
        invoice.setId();
        invoiceHashMap.put(invoice.getId(), invoice);


        //to print the invoice
        invoice.printInvoice();


    }


    public static void reportStatistics() {
        sc.nextLine();
        System.out.println("         Statistics:    ");
        System.out.println("No of Items:  " + items.size());
        System.out.println("No of Invoices: " + invoiceHashMap.size());
        System.out.println("Total of Sales: " + totalSales());
    }

    public static Double totalSales(){
        Double totalSales = 0.0;
        for (Invoice invoice: invoiceHashMap.values()){
            totalSales += invoice.getTotalAmount();
        }

        return totalSales;
    }


    public static void reportAllInvoices(){
        System.out.println("    All Invoices:   ");
        for(Invoice invoice: invoiceHashMap.values()){
            invoice.printInvoice();
        }
    }


    /************ SHOP SETTINGS *************/
    public static void shopSettings() {
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
                sc.nextLine();
            } else if (word == 2) {
                setShopName();
                sc.nextLine();
            } else if (word == 3) {
                setInvoiceHeader();
            }
        } while (word != 4);

    }

    public static void loadData() {
        for (Invoice invoice: invoiceHashMap.values()){
            System.out.println(invoice.items);
        }
    }

    public static String setShopName() {
        System.out.println("Enter the shop name: ");
        String shopName = sc.nextLine();

        return shopName;
    }

    public static String setInvoiceHeader() {
        sc.nextLine();
        System.out.println("Enter The invoice header(Phone/Email/Fax/Website): ");
        String invoiceHeader = sc.nextLine();


        return invoiceHeader;
    }


    public static void manageShopItems() {
        int word;
        do {
            System.out.println("        Manage Shop Items:      ");
            System.out.println("1- Add items ");
            System.out.println("2- Delete Items ");
            System.out.println("3- Change Item price");
            System.out.println("4- Report Item Price");
            System.out.println("5- Go Back ");
            System.out.print("Enter your option: ");
            word = sc.nextInt();
            if (word == 1) {
                sc.nextLine();

                addItems();
            } else if (word == 2) {
                removeItem();

            } else if (word == 3) {
                changeItemPrice();
            } else if (word == 4) {
                reportItems();

            }
        } while (word != 5);
    }


    /***************** MANAGE SHOP ITEMS ************/
    public static void addItems() {

//        System.out.println("Enter the item number: ");
//        Integer id = sc.nextInt();

        Boolean cond= true;
        while (cond){
            System.out.println("What is the item's name: ");
            String name = sc.nextLine();
            System.out.println("What is the item's price? ");
            Float price = sc.nextFloat();
            sc.nextLine();
            System.out.println("How many did you buy? ");
            Integer quantity = sc.nextInt();

            //issuing a new item from Item class
            Item item1 = new Item(name, price, quantity);

            //creating a new id for the item everytime I run this code
            item1.setId();

            //adding item to MainMenu list items and printing the item
            items.add(item1);
            item1.print();

            //checking if item was added
            if (items.contains(item1)) {
                System.out.println("Items added Successfully!\n");
            } else {
                System.out.println("Items wasn't added!\n");
            }


            sc.nextLine();
            System.out.println("Do you want to add more items? y/n ");
            String word = sc.nextLine();
            if (word.equalsIgnoreCase("n")){
                cond=false;
            }
        }
    }

    public static void removeItem() {
        sc.nextLine();
        System.out.println("Enter the item name that you want to remove: ");
        String name = sc.nextLine();

        //I tried items.remove but it didn't work because it is not addressed the same in the code
        // but removeif does the wonderful job
        items.removeIf(item -> item.getName().equals(name));


        if (!items.contains(name)) {
            System.out.println("Item " + name + " was remove successfully!\n");
        } else {
            System.out.println("Items wasn't remove successfully!\n");
        }

    }

    public static void changeItemPrice() {
        sc.nextLine();

        System.out.println("Enter the item number that you want to change its price: ");
        Integer itemNo = sc.nextInt();

        System.out.println("Enter the new price: ");
        Float newPrice = sc.nextFloat();
        for (Item item : items) {
            if (item.id == itemNo) {
                item.setPrice(newPrice);
                System.out.println("Item price was changed successfully!\n");
            } else {
                System.out.println("Item not found!\n");
            }
        }

    }

    public static void reportItems() {
        for (Item item : items) {
            item.print();
        }

    }


}
