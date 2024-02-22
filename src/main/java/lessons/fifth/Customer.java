package lessons.fifth;

class Customer implements Runnable {
    private final String name;
    private final Warehouse warehouse;

    public Customer(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        int restockTimes = 10;
        while (restockTimes > 0) {
            synchronized (warehouse) {
                int quantityBought = warehouse.sell();
                if (quantityBought > 0) {
                    System.out.println(name + " bought " + quantityBought + " items."
                            + " Balance - " + warehouse.getStock());
                } else {
                    break;
                }

                if (warehouse.isNeedRestock()) {
                    warehouse.restock();
                    restockTimes--;
                }
            }
        }

        if (restockTimes == 0) {
            synchronized (warehouse) {
                System.out.println("Finish sale started!");
                while (warehouse.getStock() > 0) {
                    System.out.println(name + " bought " + warehouse.sell() + " items!"
                            + " Balance - " + warehouse.getStock());
                }
                System.out.println("Finish sale complete. All items sold out.");
            }
        }
        System.out.println(name + " finished shopping.");
    }
}
