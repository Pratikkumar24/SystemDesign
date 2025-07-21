package VendingMachineV2.States;

import VendingMachineV2.Machine;
import VendingMachineV2.Products.Product;
import VendingMachineV2.Coin;

public interface StateInterface {
    public void insertCoin(Machine machine, Coin coin);
    public int returnMoney(Machine machine);
    public Product selectProduct(Machine machine, int code); //Returns a product code for this
    public void depenseProduct(Machine machine, Product product);
}
