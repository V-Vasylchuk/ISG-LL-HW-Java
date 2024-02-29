package lessons.sixth.shop.service;

import java.math.BigDecimal;
import java.util.List;
import lessons.sixth.shop.model.Product;

public interface ProductService {
    void addProduct(String title, BigDecimal price, int quantity);

    Product getProductById(Long id);

    void removeProductById(Long id);

    void removeProductByTitle(String title);

    void sortProducts(String order);

    List<Product> filterProducts(String keyword);

    void displayProducts();
}
