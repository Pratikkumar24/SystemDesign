package VendingMachineV2.Products;

public class Product {
    private String productName;
    private int productPrice;
    private int productCode;

    public Product(String name, int price, int code) {
        this.productName = name;
        this.productPrice = price;
        this.productCode = code;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public int getProductCode() {
        return this.productCode;
    }
}
