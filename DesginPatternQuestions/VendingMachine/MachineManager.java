package VendingMachine;

import VendingMachine.StateClass.Idle;

public class MachineManager {
    private Machine machine = Machine.getInstance();
    private VendingStates state;
    public MachineManager() {
        state = new Idle();
        machine.init();
    }

    public void addProduct(String name, int price) {
        machine.addProduct(name, price);
    }

    public void showProduct() {
        machine.showProducts();
    }
    
    public void setState(VendingStates newState) {
        state = newState;
    }

    public void pressInsertButton() {
        state.pressInsertButton(this, machine);
    }

    public void insertCoins(Coin coin) {
        state.insertCoin(this, machine, coin);
    }

    public void goToProductSelectionState() {
        state.selectProduct(this, machine);
    }

    public boolean chooseProduct(int code) {
        return state.chooseProduct(this, machine, code);
    }

    public void dispenceProduct() {
        Item item = state.dispenceProduct(this, machine);
        System.out.println("Your product details:"+item.getItemName()+" price: "+ item.getItemValue());
    } 

    public void cancel() {
        state.refundFullMoney(this, machine);
    }
}
