package lessons.sixth.shop.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private int quantity;

    public Product(Long id, String title, BigDecimal price, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity && id.equals(product.id) && title.equals(product.title) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, quantity);
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", price=" + price
                + ", quantity=" + quantity
                + '}';
    }
}
