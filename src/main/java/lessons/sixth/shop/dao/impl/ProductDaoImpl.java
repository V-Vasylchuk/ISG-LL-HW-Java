package lessons.sixth.shop.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import lessons.sixth.shop.dao.ProductDao;
import lessons.sixth.shop.exeption.DataProcessingException;
import lessons.sixth.shop.model.Product;
import lessons.sixth.shop.storage.Catalog;

public class ProductDaoImpl implements ProductDao {
    private final Catalog catalog;

    public ProductDaoImpl() {
        this.catalog = new Catalog();
    }

    @Override
    public void addProduct(String title, BigDecimal price, int quantity) {
        Long id = catalog.getIdGenerator().getAndIncrement();
        Product product = new Product(id, title, price, quantity);
        catalog.getProductsCatalog().add(product);
    }

    @Override
    public Product getById(Long id) {
        return catalog.getProductsCatalog()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataProcessingException("Product with id: "
                        + id + " doesn't exist!"));
    }

    @Override
    public boolean delete(Long id) {
        return catalog.getProductsCatalog().removeIf(product -> product.getId().equals(id));
    }

    @Override
    public boolean removeProductByTitle(String title) {
        return catalog.getProductsCatalog().removeIf(product -> product.getTitle().equals(title));
    }

    @Override
    public List<Product> getAll() {
        return catalog.getProductsCatalog();
    }
}
