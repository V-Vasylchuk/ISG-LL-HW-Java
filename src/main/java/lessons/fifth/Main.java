package lessons.fifth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(1000); // initial stock of goods
        Customer[] customers = new Customer[3];

        // initialize customers
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer("Customer " + (i + 1), warehouse);
        }

        // Creating a pool of threads for customers
        try (ExecutorService executor = Executors.newFixedThreadPool(customers.length)) {
            // launch customers in separate threads
            for (Customer customer : customers) {
                executor.execute(customer);
            }
        }
    }
}
