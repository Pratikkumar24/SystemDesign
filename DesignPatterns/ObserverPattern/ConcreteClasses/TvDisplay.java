package ObserverPattern.ConcreteClasses;

import ObserverPattern.Interface.TempObserver;

public class TvDisplay implements TempObserver{

    @Override
    public void updateTemp(int temp) {
        System.out.println("TV update: temp = "+temp);
    }
}
