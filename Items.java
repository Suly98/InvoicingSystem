package InvoiceSystem;

import java.util.Objects;

public class Items {
    Integer id;
    String name;
    Float price;
    Integer quantity;

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
        Items items = (Items) o;
        return Objects.equals(id, items.id) && Objects.equals(name, items.name) && Objects.equals(price, items.price) && Objects.equals(quantity, items.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
