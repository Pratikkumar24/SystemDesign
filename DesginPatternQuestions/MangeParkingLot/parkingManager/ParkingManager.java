package MangeParkingLot.parkingManager;

import MangeParkingLot.parkingLot.ParkingLot;
import MangeParkingLot.strategy.paymentStrategy.Payment;
import MangeParkingLot.ticket.Ticket;
import MangeParkingLot.vehicle.Vehicle;

public class ParkingManager {
    ParkingLot parkingLot;

    public ParkingManager() {
        parkingLot = ParkingLot.getParkingInstance();
        parkingLot.initilizeParkingLot();
    }


    public Ticket getTicket(Vehicle vehicle) {
        return parkingLot.generateTicket(vehicle);
    }

    public void exitVehicle(Ticket ticket, Payment payment) {
        if (ticket == null) {
            System.out.println("Parking is not valid, please get the new ticket");
            return;
        }
        parkingLot.payAmount(ticket, payment);
    }
}
