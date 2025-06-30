package AdapterDesign;

import AdapterDesign.Adapter.FlatPinAdapter;
import AdapterDesign.RoundCharger.RoundChargePinImpl;

public class Main {
    public static void main(String[] args) {
        FlatPinAdapter adapter = new FlatPinAdapter();

        adapter.chargeWithFlatPin(); //internally uses the round pin -> to make round and flat pin compatible

        RoundChargePinImpl roundPin = new RoundChargePinImpl();

        roundPin.chargeWithRoundPin(); // charging with round pin
    }
}
