package lessons.sixth.shop.service.impl;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lessons.sixth.shop.dao.ProductDao;
import lessons.sixth.shop.dao.impl.ProductDaoImpl;
import lessons.sixth.shop.model.Product;
import lessons.sixth.shop.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDaoImpl();
    }


    @Override
    public Product getProductById(Long id) {
       return productDao.getById(id);
    }


    @Override
    public void addProduct(String title, BigDecimal price, int quantity) {
        productDao.addProduct(title, price, quantity);
    }

    @Override
    public void removeProductById(Long id) {
        if (productDao.delete(id)) {
            System.out.println("Product with id : " + id + " was deleted");
            return;
        }
        System.out.println("Product with id : " + id + " doesn't exist");
    }

    @Override
    public void removeProductByTitle(String title) {
        if (productDao.removeProductByTitle(title)) {
            System.out.println("Product with title: " + title + " was deleted");
            return;
        }
        System.out.println("Product with title: " + title + " doesn't exist");
    }

    @Override
    public void sortProducts(String order) {
        Comparator<Product> comparator = Comparator.comparing(Product::getTitle);

        if (order.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
            productDao.getAll().sort(comparator);
            System.out.println("Product sorted by descending order");
        } else if (order.equalsIgnoreCase("asc")) {
            productDao.getAll().sort(comparator);
            System.out.println("Product sorted by ascending order");
        } else {
            System.out.println("Invalid order");
        }
    }

    @Override
    public List<Product> filterProducts(String keyword) {
        return productDao.getAll()
                .stream()
                .filter(product -> product.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public void displayProducts() {
        productDao.getAll()
                .forEach(System.out::println);
    }
}
