package SystemDesign.DesginPatternQuestions.VendingMachine;

public class Machine {
    private static Machine machine = null;
    private ItemSelf[] itemSelfs;
    private int bankBalance;
    private int currSelectProductCode = -1;
    int itemSize = 10;

    private Machine() {
    }

    public void init() {
        this.itemSelfs = new ItemSelf[itemSize];
        bankBalance = 0;
    }

    public static Machine getInstance() {
        
        if(machine == null) {
            machine = new Machine();
        }
        return machine;
    }

    public void addCoins(Coin coin) {
        bankBalance+=coin.getValue();
    }

    public int totalMoney() {
        return bankBalance;
    }

    public boolean isProductCodeAvailable(int code) {
        for(ItemSelf itemSelf:  itemSelfs) {
            if(code == itemSelf.getCode() && !itemSelf.isItemSold() && itemSelf.getItem().getItemValue()<=totalMoney()) {
                return true;
            }
        }
        return false;
    }

    public Item getProduct() {
        for(ItemSelf itemSelf:  itemSelfs) {
            if(currSelectProductCode == itemSelf.getCode()) {
                removeCoins(itemSelf.getItem().getItemValue());
                return itemSelf.getItem();
            }
        }
        return null;
    }

    public void removeCoins(int price) {
        bankBalance-=price;
    }

    public int getSelectedProductedCode(int code) {
        return currSelectProductCode;
    }

    public void setSelectedProductedCode(int code) {
        this.currSelectProductCode = code;
    }
}
