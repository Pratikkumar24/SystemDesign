package Entities;
import Utility.TicketGenerator;
import interfaces.Vehicle;

public class Ticket {
    int ticketId;
    ParkingSpot parkingSpot;
    long entryTime;
    Vehicle vehicle;
    TicketGenerator ticketGenerator = new TicketGenerator();

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();

        updatedId();
    }   

    private void updatedId() {
        this.ticketId = ticketGenerator.generateId();
    }

    public int getTicketId() {
        return this.ticketId;
    }
}
