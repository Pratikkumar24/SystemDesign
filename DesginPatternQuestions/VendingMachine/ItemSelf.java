package VendingMachine;

public class ItemSelf {
    private Item item;
    private int code;
    private boolean isSold;


    public ItemSelf(Item item, int code) {
        this.item = item;
        this.code = code;
        isSold = false;
    }

    public int getCode() {
        return this.code;
    }

    public Item getItem() {
        return this.item;
    }
    
    public boolean isItemSold() {
        return this.isSold;
    }

    public void setSold() {
        this.isSold = true;
    }
}
