package InvoiceSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {
    public static int counter = 1;
    Integer id;
    String name;
    Float price;
    Integer quantity;
    List<Item> items = new ArrayList<>();

    public Item(String name, Float price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

//    public void printAll(){
//        System.out.println(items);
//    }

    /*-------------fUNCTIONS------------*/
    //to add items
    public void addToList(Item item) {
        items.add(item);
        System.out.println(items.toString());
    }

    //to print all items
    public void print() {
        System.out.println("Item No: " + calculateId());
        System.out.println("Item Name: " + name);
        System.out.printf("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    //to delete items
    public void removeItem(Item item) {
        items.remove(item);
    }

    //to change item price
    public void changeItemPrice(Item item, Float newPrice) {
        item.setPrice(newPrice);
    }

    public double total() {
        double total = 0;
        total += price * quantity;

        return total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = calculateId();
    }

    public int calculateId() {
        return Item.counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(quantity, item.quantity) && Objects.equals(items, item.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, items);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
