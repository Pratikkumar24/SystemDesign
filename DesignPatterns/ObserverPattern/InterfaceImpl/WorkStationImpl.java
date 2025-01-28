package ObserverPattern.InterfaceImpl;

import java.util.*;

import ObserverPattern.Interface.TempObserver;
import ObserverPattern.Interface.WorkStationObserval;

public class WorkStationImpl implements WorkStationObserval {
    List<TempObserver> temperatureObserver;
    int temp;

    public WorkStationImpl() {
        this.temp = 0;
        temperatureObserver = new ArrayList<TempObserver>();
    }

    @Override
    public void addObserver(TempObserver tempObserver) {
        System.out.println("Added a substation");
        temperatureObserver.add(tempObserver);
    }

    @Override
    public void removeObserver(TempObserver tempObserver) {
        System.out.println("Removed a substation");
        temperatureObserver.remove(tempObserver);
    }

    @Override
    public void notifyObserver() {
        System.out.println("--Notifying all the stations--");
        for(TempObserver t: temperatureObserver) {
            t.updateTemp(temp);
        }
    }

    @Override
    public int getTemp() {
        return temp;
    }

    @Override
    public void setTemp(int temp) {
        if(this.temp != temp) {
            this.temp = temp;
            System.out.println("Temperature changed to "+this.temp+" -> Need to notify all");
            notifyObserver();
        } else {
            System.out.println("Temperature remains the same, no need to notify");
        }
    }
}
