package VendingMachine;

public class Main {
    public static void main(String[] args) {
        MachineManager manager = new MachineManager();
        init(manager);

        //Press insert buttom
        //insert money
        //choose product
        //press for despence product

        manager.pressInsertButton();
        manager.insertCoins(Coin.HUNDRED);
        manager.insertCoins(Coin.TWENTY);
        manager.goToProductSelectionState();
        boolean productAvailable = manager.chooseProduct(105);
        if(productAvailable) {
            manager.dispenceProduct();
        }

    }

    public static void init(MachineManager manager) {
        manager.addProduct("coke", 30);
        manager.addProduct("sprite", 25);
        manager.addProduct("thumbsUp", 30);
        manager.addProduct("lays", 10);
        manager.addProduct("uncleChips", 50);

        manager.showProduct();
    }
}
