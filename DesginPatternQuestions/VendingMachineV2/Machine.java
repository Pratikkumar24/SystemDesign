package VendingMachineV2;

import java.util.List;

import VendingMachineV2.Products.Product;
import VendingMachineV2.States.NoMoneyState;
import VendingMachineV2.States.StateInterface;

public class Machine {
    Repository repository;
    StateInterface state;
    public Machine(Repository repository) {
        this.repository = repository;
        state = new NoMoneyState();
    }

    public Repository getRepository() {
        return this.repository;
    }
    public void setState(StateInterface newState) {
        state = newState;
    }

    public void showProducts() {
        List<Product> products = repository.getProducts();
        for(Product product: products) {
            System.out.println("Name: "+ product.getProductName()+" price: "+ product.getProductPrice()+" code:"+product.getProductCode());
        }
    }
    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void refundFullMoney() {
        int balance = state.returnMoney(this);
        System.out.println("Total refunded money is: "+ balance);
    }

    public Product selectProduct(int code) {
        return state.selectProduct(this, code);
    }

    public void dispenceProduct(Product product) {
        state.depenseProduct(this, product);
    }
}
