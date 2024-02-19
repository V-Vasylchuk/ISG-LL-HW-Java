package lessons.first.shop;

public class Shop {
    public static void main(String[] args) {
        // Створюємо декілька товарів
        Product smartphone = new Product("Smartphone",
                500.0, "Brand: XYZ, RAM: 8GB");
        Product laptop = new Product("Laptop",
                1000.0, "Brand: ABC, Processor: Intel Core i7");
        Product tv = new Product("TV",
                800.0, "Brand: DEF, Screen Size: 55 inches");

        // Створюємо кошик покупок та додаємо товари до нього
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Your shopping card:");
        cart.addProduct(smartphone);
        System.out.println(smartphone);
        cart.addProduct(laptop);
        System.out.println(laptop);
        cart.addProduct(tv);
        System.out.println(tv);

        // Виводимо загальну суму покупок
        System.out.println("Total: $" + cart.calculateTotal());
    }
}
