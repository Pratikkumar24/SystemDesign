package VendingMachineV2.States;

import VendingMachineV2.Coin;
import VendingMachineV2.Machine;
import VendingMachineV2.Products.Product;

public class NoMoneyState implements StateInterface{

    @Override
    public void insertCoin(Machine machine, Coin coin) {
        machine.getRepository().creditedMoney(coin);
        machine.setState(new HasMoneyState());
    }

    @Override
    public int returnMoney(Machine machine) {
        System.out.println("Returning all the balance!!");
        return machine.getRepository().returnBalance();
    }

    @Override
    public Product selectProduct(Machine machine, int code) {
        System.out.println("Can't select product, please enter some money!");
        return null;
    }

    @Override
    public void depenseProduct(Machine machine, Product product) {
        System.out.println("Please select some product first..");
    }
    
}
