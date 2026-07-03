package Generics;

import java.util.*;

abstract class Category {
    String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends Category {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends Category> {
    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public void display() {
        System.out.println("Product: " + productName);
        System.out.println("Category: " + category.getCategoryName());
        System.out.println("Price: ₹" + price);
        System.out.println();
    }
}

class Marketplace {

    // Generic Method
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }

    // Wildcard Method
    public static void displayCatalog(List<? extends Product<?>> catalog) {
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}

public class DynamicOnlineMarketplace {

    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("Java Programming", 800, new BookCategory());

        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> laptop = new Product<>("Laptop", 60000, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(laptop);

        System.out.println("Before Discount:");
        Marketplace.displayCatalog(catalog);

        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(shirt, 20);
        Marketplace.applyDiscount(laptop, 15);

        System.out.println("After Discount:");
        Marketplace.displayCatalog(catalog);
    }
}
