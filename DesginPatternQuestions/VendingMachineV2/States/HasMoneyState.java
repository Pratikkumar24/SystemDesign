package VendingMachineV2.States;

import java.util.List;

import VendingMachineV2.Coin;
import VendingMachineV2.Machine;
import VendingMachineV2.Products.Product;

public class HasMoneyState implements StateInterface{

    @Override
    public void insertCoin(Machine machine, Coin coin) {
        machine.getRepository().creditedMoney(coin);
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
    public void depenseProduct(Machine machine, Product product) {
        //if product is already selected
        if (machine.getRepository().getSelectedProduct() == null) {
            System.out.println("Please select some product first..");
        } else {
            System.out.println("So you are dispensing "+machine.getRepository().getSelectedProduct().getProductName()+", Then please dispense this..");
            machine.setState(new DispenceProduct());
        }
        
    }
}
