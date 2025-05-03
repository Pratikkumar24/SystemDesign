package MangeParkingLot.strategy.calculationStrategy;

public class TwoWheelerPPCalculator implements ParkingPriceCalculator{
    int priceOverTime = 10;

    @Override
    public int calculate(long startTime) {
        long currentTime = System.currentTimeMillis();
        long totalSeconds = ((currentTime - startTime)/1000)%60;
        System.out.println("Total seconds remaind: "+ totalSeconds);
        return (int) totalSeconds * priceOverTime;
    }
}
