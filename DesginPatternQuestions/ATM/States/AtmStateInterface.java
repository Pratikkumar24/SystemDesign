package ATM.States;

import ATM.Card.ICard;

public interface AtmStateInterface {
    public void insertCard(ICard card);
    public void enterPin(int pin);
}
