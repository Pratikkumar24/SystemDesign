package InventoryManagement.Products;

import InventoryManagement.Builder.ProductBuilder;

public class Pants extends Product {

    public Pants(ProductBuilder builder) {
        int productPrice = 30;
        int productId = builder.getProductId();
        int quantity = builder.getTotalQuantity();
        String productName = builder.getProductName();

        super(new ProductBuilder(productName)
        .setProductId(productId)
        .setProductPrice(productPrice)
        .setProductType(ProductType.PANTS)
        .setTotalQuantity(quantity));
    }
}
