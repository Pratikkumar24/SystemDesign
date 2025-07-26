package ATM.DispensorHandler;

import ATM.Enum.Money;

public class OneHundredDispensor extends IDispensorHandler{

    public OneHundredDispensor() {
        this.moneyDispensor = Money.ONE_HUNDRED;
    }

    @Override
    public void dispenseMoney(int money) {
        //todo: Need to write the logic
    }
    
}
