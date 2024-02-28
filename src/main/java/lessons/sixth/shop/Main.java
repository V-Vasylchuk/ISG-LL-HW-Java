package lessons.sixth.shop;

/*  Створити консольну апку каталога продуктів, де можна побачити список продуктів, додати новий,
    видалити який захочемо (індекс та ім'я), посортувати, відфільтрувати.
 */

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import lessons.sixth.shop.model.Product;
import lessons.sixth.shop.service.ProductService;
import lessons.sixth.shop.service.impl.ProductServiceImpl;
import lessons.sixth.shop.util.CatalogUtil;

public class Main {
    private static final ProductService productService = new ProductServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CatalogUtil.addProductsForTesting(productService);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add product");
            System.out.println("2. Remove product by ID");
            System.out.println("3. Remove product by title");
            System.out.println("4. Sort products");
            System.out.println("5. Filter products");
            System.out.println("6. Display products");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product title: ");
                    String productTitle = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    BigDecimal productPrice = scanner.nextBigDecimal();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    productService.addProduct(productTitle, productPrice, productQuantity);
                    break;
                case 2:
                    System.out.print("Enter ID of product to remove: ");
                    Long idToRemove = scanner.nextLong();
                    productService.removeProductById(idToRemove);
                    break;
                case 3:
                    System.out.print("Enter title of product to remove: ");
                    String titleToRemove = scanner.nextLine();
                    productService.removeProductByTitle(titleToRemove);
                    break;
                case 4:
                    System.out.print("Enter sorting order (asc/desc): ");
                    String sortingOrder = scanner.nextLine();
                    productService.sortProducts(sortingOrder);
                    break;
                case 5:
                    System.out.print("Enter keyword to filter products: ");
                    String keyword = scanner.nextLine();
                    List<Product> filteredProducts = productService.filterProducts(keyword);
                    System.out.println("Filtered products: " + filteredProducts.toString());
                    break;
                case 6:
                    System.out.println("Catalog:");
                    productService.displayProducts();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }
}