package StateDesign;

public class OffState implements StateInterface {
    @Override
    public void pressButtom(Fan fan) {
        System.out.println("Switching to On State");
        fan.setState(new OnState());
    }

}
