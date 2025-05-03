package MangeParkingLot.strategy.calculationStrategy;

public class ThreeWheelerPPCalculator implements ParkingPriceCalculator{
    int priceOverTime = 20;
    
    @Override
    public int calculate(long startTime) {
        long currentTime = System.currentTimeMillis();
        long totalSeconds = ((currentTime - startTime)/1000)%60;
        System.out.println("Total seconds remaind: "+ totalSeconds);
        return (int) totalSeconds * priceOverTime;
    }
}
