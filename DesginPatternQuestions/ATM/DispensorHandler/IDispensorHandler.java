package ATM.DispensorHandler;

import ATM.Enum.Money;

public abstract class IDispensorHandler implements IHandler{
    IHandler handler;
    Money moneyDispensor;

    @Override
    public void setNextHandler(IHandler handler) {
        this.handler = handler;
    }
}
