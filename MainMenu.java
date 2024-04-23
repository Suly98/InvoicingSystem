package InvoiceSystem;

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
                //searchInvoices();
            } else if (word == 7) {
                // programStatistics();
            }
        } while (word != 8);

    }


    public static void createNewInvoice() {
        sc.nextLine();
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
        invoice.setFullName(customer);
        invoice.setHeader(setInvoiceHeader());
        invoice.setDate(date);
        invoice.setPaidAmount(amountPaid);

        //adding invoice to the invoice map:
        invoiceHashMap.put(invoice.getId(), invoice);



//        (date, customerName,
//                setInvoiceHeader(), invoice.NoOfItems,
//                invoice.total(), invoice.getPaidAmount(),
//                invoice.getBalance());

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
            totalSales += invoice.total();
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
            } else if (word == 2) {
                setShopName();
            } else if (word == 3) {
                setInvoiceHeader();
            }
        } while (word != 4);
    }

    public static void loadData() {
//        for (Item item: items)

    }

    public static String setShopName() {
        sc.nextLine();
        System.out.println("Enter the shop name: ");
        String shopName = sc.nextLine();
        System.out.println("The new shop is: " + shopName);

        return shopName;
    }

    public static String setInvoiceHeader() {
        sc.nextLine();
        System.out.println("Enter The invoice header(Phone/Email/Fax/Website): ");
        String invoiceHeader = sc.nextLine();

        System.out.println("The Invoice Header is: " + invoiceHeader);

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
                addItems();
            } else if (word == 2) {
                removeItem();

            } else if (word == 3) {
                changeItemPrice();
            } else if (word == 4) {
                reportItems();

            }
        } while (word != 4);
    }


    /***************** MANAGE SHOP ITEMS ************/
    public static void addItems() {
        sc.nextLine();
        System.out.println("Enter the item number: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("What is the item's name: ");
        String name = sc.nextLine();
        System.out.println("What is the item's price? ");
        Float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("How many did you buy? ");
        Integer quantity = sc.nextInt();


        Item item1 = new Item(name, price, quantity);
        items.add(item1);

        item1.print();
        if (items.contains(item1)) {
            System.out.println("Items added Successfully!\n");
        } else {
            System.out.println("Items wasn't added!\n");
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
