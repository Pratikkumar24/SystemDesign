package InventoryManagement.Products;

import InventoryManagement.Builder.ProductBuilder;

public class Shirts extends Product {

    public Shirts(ProductBuilder builder) {
        int productPrice = 20;
        int productId = builder.getProductId();
        int quantity = builder.getTotalQuantity();
        String productName = builder.getProductName();

        super(new ProductBuilder(productName)
        .setProductId(productId)
        .setProductPrice(productPrice)
        .setProductType(ProductType.SHIRT)
        .setTotalQuantity(quantity));
    }
}
