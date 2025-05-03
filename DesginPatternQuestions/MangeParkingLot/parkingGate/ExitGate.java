package MangeParkingLot.parkingGate;

import MangeParkingLot.factory.CalculatorFactory;
import MangeParkingLot.strategy.calculationStrategy.ParkingPriceCalculator;
import MangeParkingLot.strategy.paymentStrategy.Payment;
import MangeParkingLot.ticket.Ticket;
import MangeParkingLot.vehicle.VehicleType;

public class ExitGate {
    private CalculatorFactory factory;

    public ExitGate() {
        factory = new CalculatorFactory();
    }
    public int exit(Ticket ticket, Payment payment) {
        int parkingSpaceId = ticket.getParkingSpace().getParkingSpaceId();
        payAmount(ticket.getEntranceTime(), ticket.getVehicle().getVehicleType(), payment);
        return parkingSpaceId;
    }

    private void payAmount(long startTime, VehicleType vehicleType, Payment payment) {
        ParkingPriceCalculator priceCalculator = factory.getParkingPriceCalculator(vehicleType);
        int amount = priceCalculator.calculate(startTime);
        payment.pay(amount);
    }
}
