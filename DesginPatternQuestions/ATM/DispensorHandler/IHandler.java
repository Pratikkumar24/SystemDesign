package ATM.DispensorHandler;

public interface IHandler {
    public void setNextHandler(IHandler handler);
    public void dispenseMoney(int money);
}
