package Generics;

import java.util.*;

// Abstract class
abstract class WarehouseItem {
    String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public abstract void display();
}

// Electronics class
class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Electronics: " + name);
    }
}

// Groceries class
class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Groceries: " + name);
    }
}

// Furniture class
class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Furniture: " + name);
    }
}

// Generic Storage Class
class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void displayItems() {
        for (T item : items) {
            item.display();
        }
    }
}

// Main class
public class SmartWarehouse {

    // Wildcard Method
    public static void showAllItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            item.display();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicStorage = new Storage<>();
        electronicStorage.addItem(new Electronics("Laptop"));
        electronicStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        electronicStorage.displayItems();

        System.out.println("\nGroceries:");
        groceryStorage.displayItems();

        System.out.println("\nFurniture:");
        furnitureStorage.displayItems();

        System.out.println("\nUsing Wildcard Method:");

        showAllItems(electronicStorage.getItems());
        showAllItems(groceryStorage.getItems());
        showAllItems(furnitureStorage.getItems());
    }
}
