package ObserverPattern.ConcreteClasses;

import ObserverPattern.Interface.TempObserver;

public class MonitorObserver implements TempObserver {

    @Override
    public void updateTemp(int temp) {
        System.out.println("Monitor update: Temp = "+ temp);
    }
    
}
