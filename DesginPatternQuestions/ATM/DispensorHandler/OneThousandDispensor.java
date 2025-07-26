package ATM.DispensorHandler;

import ATM.Enum.Money;

public class OneThousandDispensor extends IDispensorHandler{

    public OneThousandDispensor() {
        this.moneyDispensor = Money.ONE_THOUSAND;
    }
    
    @Override
    public void dispenseMoney(int money) {
        //todo: Need to write the logic
    }
    
}
