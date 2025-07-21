package VendingMachineV2;

import java.util.ArrayList;
import java.util.List;

import VendingMachineV2.Products.Product;

public class Repository {
    List<Product> products = new ArrayList<>();
    Boolean productInitialized = false;
    int balance = 0;
    Product currentProduct = null;

    private Repository() {
    } 

    public static class Holder {
        public static Repository INSTANCE = new Repository();
    }

    public static synchronized Repository getInstance() {
        return Holder.INSTANCE;
    }

    private void initProducts() {
        if (productInitialized == true) {
            return;
        }
        productInitialized = true;
        products.add(new Product("Coke", 25, 124));
        products.add(new Product("Pepsi", 25, 125));
        products.add(new Product("Fanta", 20, 126));
        products.add(new Product("Lays", 10, 127));
        products.add(new Product("Cheetos", 5, 128));
        products.add(new Product("Marigold", 5, 130));
    }

    public List<Product> getProducts() {
        initProducts();
        return products;
    }

    public void creditedMoney(Coin coin) {
        balance+=coin.getValue();
    }

    public int returnBalance() {
        int refund = balance;
        balance = 0;
        return refund;
    }

    public void debitMoney(Product product) {
        products.remove(product);
        balance-=product.getProductPrice();
    }

    public boolean enoughBalance(Product product) {
        return product.getProductPrice()<=balance;
    }

    public void setSelectedProduct(Product product) {
        currentProduct = product;
    }

    public Product getSelectedProduct() {
        return currentProduct;
    }

    public void showBalance() {
        System.out.println("Total balance: "+ balance+" rs");
    }
}
