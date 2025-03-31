package SystemDesign.DesginPatternQuestions.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    VendingStates states;
    ItemSelf[] itemSelfs;
    List<Coin> coins;

    public Machine(int itemSize) {
        this.itemSelfs = new ItemSelf[itemSize];
        coins = new ArrayList<>();
    }

    void setState(VendingStates state) {
        this.states = state;
    }

}
