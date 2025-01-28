package ObserverPattern.Interface;

public interface WorkStationObserval {
    public void addObserver(TempObserver tempObserver);
    public void removeObserver(TempObserver tempObserver);
    public int getTemp();
    public void notifyObserver();
    public void setTemp(int temp);
}
