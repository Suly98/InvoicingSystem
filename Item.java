package InvoiceSystem;

import java.util.List;
import java.util.Objects;

public class Item {
    Integer id;
    String name;
    Float price;
    Integer quantity;
    List<Item> items;

    //to add items
    public void addItems(Item item){
        items.add(item);
    }

    public static void loadItems(Item items){
        System.out.println(items.toString());
    }

    //to delete items
    public void delItems(Item item){
        items.remove(item);
    }

    //to change item price
    public void changeItemPrice(Item item, Float newPrice) {
        item.setPrice(newPrice);
    }


    public Item(String name, Float price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setPrice(Float price) {
        this.price = price;
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
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", items=" + items +
                '}';
    }
}
