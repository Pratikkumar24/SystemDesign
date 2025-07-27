package InventoryManagement.Builder;

import InventoryManagement.Products.Product;
import InventoryManagement.Products.ProductType;

public class ProductBuilder {
    private int productId = 0;
    private String productName;
    private int productPrice = 0;
    private ProductType type = ProductType.UNKNOWN;
    private int quantity = 1;

    public ProductBuilder(String name) {
        this.productName = name;
    }

    public ProductBuilder setProductId(int id) {
        this.productId = id;
        return this;
    }

    public ProductBuilder setProductPrice(int price) {
        this.productPrice = price;
        return this;
    }

    public ProductBuilder setProductType(ProductType type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setTotalQuantity(int q) {
        this.quantity = q;
        return this;
    }
    public int getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public ProductType getProductType() {
        return this.type;
    }

    public int getTotalQuantity() {
        return this.quantity;
    }

    public int getProductPrice() {
        return this.productPrice;
    }
    
    public Product build() {
        return new Product(this);
    }
}
