package ATM.DispensorHandler;

import ATM.Enum.Money;

public class FiveHundredDispensor extends IDispensorHandler{

    public FiveHundredDispensor() {
        this.moneyDispensor = Money.FIVE_HUNDRED;
    }
    
    @Override
    public void dispenseMoney(int money) {
        //todo: Need to write the logic
    }
    
}
