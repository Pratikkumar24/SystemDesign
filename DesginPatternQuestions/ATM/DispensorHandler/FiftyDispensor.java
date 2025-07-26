package ATM.DispensorHandler;

import ATM.Enum.Money;

public class FiftyDispensor extends IDispensorHandler{

    public FiftyDispensor() {
        this.moneyDispensor = Money.FIFTY;
    }

    @Override
    public void dispenseMoney(int money) {
        //todo: Need to write the logic
    }
    
}
