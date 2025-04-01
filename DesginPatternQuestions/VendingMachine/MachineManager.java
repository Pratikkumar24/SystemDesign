package SystemDesign.DesginPatternQuestions.VendingMachine;

import SystemDesign.DesginPatternQuestions.VendingMachine.StateClass.Idle;

public class MachineManager {
    Machine machine = Machine.getInstance();
    VendingStates state;
    public MachineManager() {
        state = new Idle();
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

    public void chooseProduct(int code) {
        state.chooseProduct(this, machine, code);
    }

    public void dispenceProduct() {
        Item item = state.dispenceProduct(this, machine);
        System.out.println("Your product details:"+item.getItemName()+" price: "+ item.getItemValue());
    } 

    public void cancel() {
        state.refundFullMoney(this, machine);
    }
}
