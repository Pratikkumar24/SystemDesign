package SystemDesign.DesginPatternQuestions.VendingMachine;

public class ItemSelf {
    Item item;
    int code;
    boolean isSold;

    public ItemSelf(Item item, int code) {
        this.item = item;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isItemSold() {
        return this.isSold;
    }

    public void setSold() {
        this.isSold = true;
    }
}
