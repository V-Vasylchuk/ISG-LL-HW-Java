package lessons.fifth;

import java.util.Random;

public class Warehouse {
    private static final double RESTOCK_THRESHOLD = 0.2;
    private static final int MAX_STOCK = 100;
    private int stock;
    private final Random random = new Random();

    public Warehouse(int initialStock) {
        this.stock = initialStock;
    }

    public synchronized int sell() {
        // Random number of products from 1 to 10 for bought
        int quantity = random.nextInt(10) + 1;
        if (stock >= quantity) {
            stock -= quantity;
            return quantity;
        } else {
            int sold = stock;
            stock = 0;
            return sold;
        }
    }

    public synchronized boolean isNeedRestock() {
        return stock < MAX_STOCK * RESTOCK_THRESHOLD;
    }

    public synchronized void restock() {
        System.out.println("Restocking...");
        stock += MAX_STOCK - stock; // Підвозимо товари до максимального запасу
        System.out.println("Restocked! Current stock: " + stock + " items");
    }

    public int getStock() {
        return stock;
    }
}
