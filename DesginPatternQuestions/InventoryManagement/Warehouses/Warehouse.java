package InventoryManagement.Warehouses;

import java.util.HashMap;
import java.util.HashSet;

import InventoryManagement.Products.Pants;
import InventoryManagement.Products.Product;
import InventoryManagement.Products.ProductType;
import InventoryManagement.Products.Shirts;

public class Warehouse {
    int warehouseId;
    HashSet<Product> products;
    Locations location;

    HashMap<ProductType, Integer> productQuantityMap;

    private Warehouse() {
        productQuantityMap = new HashMap<>();
        products = new HashSet<>();
        location = Locations.BANGALORE;
    }
    
    public static class HOLDER {
        public static Warehouse instance = new Warehouse();
    }
    public static synchronized Warehouse getInstance() {
        return HOLDER.instance;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void addProduct(Product product) {
        if (product instanceof Shirts) {
            productQuantityMap.put(ProductType.SHIRT, productQuantityMap.getOrDefault(ProductType.SHIRT, 0) + 1);
        } else if (product instanceof Pants) {
            productQuantityMap.put(ProductType.PANTS, productQuantityMap.getOrDefault(ProductType.PANTS, 0) + 1);
        }
        products.add(product);
    }

    public void addProducts(Product product, int quantity) {
        if (product instanceof Shirts) {
            productQuantityMap.put(ProductType.SHIRT, productQuantityMap.getOrDefault(ProductType.SHIRT, 0) + quantity);
        } else if (product instanceof Pants) {
            productQuantityMap.put(ProductType.PANTS, productQuantityMap.getOrDefault(ProductType.PANTS, 0) + quantity);
        }
        products.add(product);
    }

    public boolean enoughQuantity(ProductType type, int quantity) {
        return productQuantityMap.getOrDefault(type, 0)>=quantity;
    }

    public void removeProducts(ProductType type, int quantity) {
        if (enoughQuantity(type, quantity)) {
            System.out.println("Not enough product to remove!!");
            return;
        }

        productQuantityMap.put(type, productQuantityMap.get(type) - quantity);
    }
}
