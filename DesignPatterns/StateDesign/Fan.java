package StateDesign;

public class Fan {
    StateInterface state;

    public Fan() {
        state = new OffState();
    }
    
    void setState(StateInterface currState) {
        this.state = currState;
    }

    void pressButtom() {
        state.pressButtom(this);
    }
}
