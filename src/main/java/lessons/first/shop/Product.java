package lessons.first.shop;

public class Product {
    private final String name;
    private final double price;
    private final String additionalInfo;

    public Product(String name, double price, String additionalInfo) {
        this.name = name;
        this.price = price;
        this.additionalInfo = additionalInfo;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", additionalInfo='" + additionalInfo + '\''
                + '}';
    }
}
