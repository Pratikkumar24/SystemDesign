package InventoryManagement;

import InventoryManagement.Products.ProductType;

public class ProductTypeFactory {
    public ProductType getProductFactory(int productId) {
        switch (productId) {
            case 1:
                return ProductType.SHIRT;
            case 2: 
                return ProductType.PANTS;
            default:
                return ProductType.UNKNOWN;
        }
    }
}
