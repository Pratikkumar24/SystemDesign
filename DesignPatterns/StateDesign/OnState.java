package StateDesign;

public class OnState implements StateInterface{
    @Override
    public void pressButtom(Fan fan) {
        System.out.println("Switching to Off state");
        fan.setState(new OffState());
    }
}
