package InventoryManagement.Services;

import java.util.HashMap;

import InventoryManagement.ProductTypeFactory;
import InventoryManagement.Products.Product;
import InventoryManagement.Products.ProductType;
import InventoryManagement.Warehouses.Warehouse;

public class AdminManager {
    ProductTypeFactory factory;
    HashMap<Integer, Warehouse> wareHouseMap;
    public AdminManager() {
        factory = new ProductTypeFactory();
        wareHouseMap = new HashMap<>();
    }

    public void addWarehouse(int id, Warehouse warehouse) {
        wareHouseMap.put(id, warehouse);
    }

    public void addProduct(int warehouseId, Product product, int quantity) {
        wareHouseMap.get(warehouseId).addProducts(product, quantity);
    }

    public void removeProduct(int warehouseId, int productId, int quantity) {
        wareHouseMap.get(warehouseId).removeProducts(factory.getProductFactory(productId), quantity);
    }

    public boolean isThereEnoughProduct(int warehouseId, ProductType type, int quantity) {
        return wareHouseMap.get(warehouseId).enoughQuantity(type, quantity);
    } 
}
