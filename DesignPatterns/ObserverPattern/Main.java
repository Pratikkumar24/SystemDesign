package ObserverPattern;

import ObserverPattern.ConcreteClasses.MobileObserver;
import ObserverPattern.ConcreteClasses.MonitorObserver;
import ObserverPattern.ConcreteClasses.TvDisplay;
import ObserverPattern.Interface.TempObserver;
import ObserverPattern.Interface.WorkStationObserval;
import ObserverPattern.InterfaceImpl.WorkStationImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("OBSERVER PATTERN");
        TempObserver mobileObserver = new MobileObserver();
        TempObserver TvDisplay = new TvDisplay();
        TempObserver monitorObserver = new MonitorObserver();

        WorkStationObserval workStationObserver = new WorkStationImpl();

        workStationObserver.addObserver(mobileObserver);
        workStationObserver.addObserver(TvDisplay);
        workStationObserver.addObserver(monitorObserver);

        // Notify
        workStationObserver.setTemp(10);

        workStationObserver.setTemp(20);

        workStationObserver.setTemp(20);

        workStationObserver.removeObserver(monitorObserver);

        workStationObserver.setTemp(50);

    }
}
