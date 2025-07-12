package AdapterDesign.Adapter;

import AdapterDesign.FlatCharger.FlatChargePin;
import AdapterDesign.RoundCharger.RoundChargePinImpl;

public class FlatPinAdapter implements FlatChargePin {

    RoundChargePinImpl chargePinImpl;

    public FlatPinAdapter() {
        chargePinImpl = new RoundChargePinImpl();
    }

    @Override
    public void chargeWithFlatPin() {
        chargePinImpl.chargeWithRoundPin();
    }
    
}
