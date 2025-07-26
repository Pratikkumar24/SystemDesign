package ATM.States;

import ATM.Card.ICard;

public class IdleState implements AtmStateInterface{

    @Override
    public void insertCard(ICard card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCard'");
    }

    @Override
    public void enterPin(int pin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterPin'");
    }
    
}
