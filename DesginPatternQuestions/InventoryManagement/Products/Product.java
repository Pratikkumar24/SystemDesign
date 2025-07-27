package InventoryManagement.Products;

import InventoryManagement.Builder.ProductBuilder;

public class Product {
    int productId;
    String productName;
    int productPrice;
    ProductType type;
    int quantity;

    public Product(ProductBuilder builder) {
        this.productName = builder.getProductName();
        this.type = builder.getProductType();
        this.quantity = builder.getTotalQuantity();
        this.productPrice = builder.getProductPrice();
    }

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public ProductType getProductType() {
        return type;
    }

}