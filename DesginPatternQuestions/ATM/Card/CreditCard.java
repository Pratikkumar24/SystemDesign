package ATM.Card;

import ATM.Enum.BankEnum;
import ATM.Enum.CardType;

public class CreditCard implements ICard {
    long cardNumber;
    int pinCode;
    String cardHolderName;
    BankEnum bank;
    DateRecord date;
    CardType cardType = CardType.CREDIT_CARD;

    public CreditCard(String name, long cardNumber, int pinCode, BankEnum bank) {
        this.cardHolderName = name;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.bank = bank;
    }

    @Override
    public long getCardNumber() {
        return this.cardNumber;
    }

    @Override
    public int getPinCode() {
        return this.pinCode;
    }

    @Override
    public String getCardHolderName() {
        return this.cardHolderName;
    }

    @Override
    public BankEnum getBank() {
        return this.bank;
    }

    @Override
    public void setExpiryDate(int day, int month, int year) {
        this.date = new DateRecord(day, month, year);
    }

    @Override
    public DateRecord getCardExpiryDate() {
        return this.date;
    }
}
