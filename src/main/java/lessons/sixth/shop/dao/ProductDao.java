package lessons.sixth.shop.dao;

import java.math.BigDecimal;
import lessons.sixth.shop.model.Product;

public interface ProductDao extends GenericDao<Product> {
    void addProduct(String title, BigDecimal price, int quantity);

    boolean removeProductByTitle(String title);

}
