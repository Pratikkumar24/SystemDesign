package ATM.Card;

import ATM.Enum.BankEnum;

public interface ICard {
    public long getCardNumber();
    public int getPinCode();
    public String getCardHolderName();
    public BankEnum getBank();
    public void setExpiryDate(int day, int month, int year);
    public DateRecord getCardExpiryDate();
}
