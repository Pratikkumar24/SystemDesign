package ObserverPattern.ConcreteClasses;

import ObserverPattern.Interface.TempObserver;

public class MobileObserver implements TempObserver{

    @Override
    public void updateTemp(int temp) {
        System.out.println("Mobile update: temp = " + temp);
    }
}
