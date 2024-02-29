package lessons.sixth.shop.util;

import java.math.BigDecimal;
import lessons.sixth.shop.service.ProductService;

public class CatalogUtil {

    public static void addProductsForTesting(ProductService productService) {
        productService.addProduct("Ліжко", new BigDecimal("1000.00"), 5);
        productService.addProduct("Стіл", new BigDecimal("500.00"), 10);
        productService.addProduct("Стілець", new BigDecimal("100.00"), 20);
        productService.addProduct("Лампа", new BigDecimal("50.00"), 15);
        productService.addProduct("Шафа", new BigDecimal("1500.00"), 8);
        productService.addProduct( "Диван", new BigDecimal("2000.00"), 3);
        productService.addProduct("Тумба", new BigDecimal("300.00"), 12);
        productService.addProduct("Крісло", new BigDecimal("200.00"), 18);
        productService.addProduct("Комод", new BigDecimal("700.00"), 7);
        productService.addProduct("Книжкова полиця", new BigDecimal("400.00"), 25);
    }
}
