package VendingMachineV2.States;

import java.util.List;

import VendingMachineV2.Coin;
import VendingMachineV2.Machine;
import VendingMachineV2.Products.Product;

public class DispenceProduct implements StateInterface{

    @Override
    public void insertCoin(Machine machine, Coin coin) {
        System.out.println("Can't insert coin now, please despense the current product!!");
    }

    @Override
    public int returnMoney(Machine machine) {
        System.out.println("Returning all the balance!!");
        machine.setState(new NoMoneyState());
        return machine.getRepository().returnBalance();
    }

     @Override
    public Product selectProduct(Machine machine, int code) {
        List<Product> products = machine.getRepository().getProducts();
        Product selectedProduct = machine.getRepository().getSelectedProduct();
        for(Product prod: products) {   
            if (prod.getProductCode() == code) {
                selectedProduct = prod;
            }
        }
        if (selectedProduct == null) {
            System.out.println("No Item exists with this code");
            return null;
        }
        System.out.println("Selected Item details->");
        System.out.println("Name: "+selectedProduct.getProductName()+", Price: "+selectedProduct.getProductPrice()+", Code:"+selectedProduct.getProductCode());
        machine.setState(new DispenceProduct());
        return selectedProduct;
    }

    @Override
    public void depenseProduct(Machine machine, Product product ) {
        if (product == null) {
            System.out.println("No product to dispense!!");
            return;
        }
        if (machine.getRepository().enoughBalance(product)) {
            System.out.println("Dispensing this product!!");
            machine.getRepository().debitMoney(product);
            machine.getRepository().setSelectedProduct(null);
            machine.setState(new NoMoneyState());
        } else {
            System.out.println("Not enough balance to buy this product!!");
            machine.setState(new HasMoneyState());
        }
        
    }
    
}
