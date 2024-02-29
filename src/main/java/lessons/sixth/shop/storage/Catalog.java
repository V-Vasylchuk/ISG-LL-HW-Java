package lessons.sixth.shop.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import lessons.sixth.shop.model.Product;

public class Catalog {
    private final List<Product> productsCatalog;
    private final AtomicLong idGenerator;

    public Catalog() {
        this.productsCatalog = new ArrayList<>();
        this.idGenerator = new AtomicLong(1);
    }

    public List<Product> getProductsCatalog() {
        return productsCatalog;
    }

    public AtomicLong getIdGenerator() {
        return idGenerator;
    }
}
