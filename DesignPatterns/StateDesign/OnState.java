package SystemDesign.DesignPatterns.StateDesign;

public class OnState implements StateInterface{
    @Override
    void pressButtom(Fan fan) {
        System.out.println("Switching to Off state");
        fan.setState(new OffState());
    }
}
