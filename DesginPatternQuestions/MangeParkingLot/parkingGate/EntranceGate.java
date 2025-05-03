package MangeParkingLot.parkingGate;

import MangeParkingLot.parkingSpace.ParkingSpace;
import MangeParkingLot.ticket.Ticket;
import MangeParkingLot.vehicle.Vehicle;

public class EntranceGate {

    public Ticket generateTicket(Vehicle vehicle, ParkingSpace parkingSpace) {
        if(parkingSpace == null) {
            System.out.println("No space for vehicle type "+ vehicle.getVehicleType());
            return null;
        }
        Ticket ticket = new Ticket(vehicle, parkingSpace);
        show(vehicle, ticket);
        return ticket;
    }

    public void show(Vehicle vehicle, Ticket ticket) {
        System.out.println("|----------------------------------------------------|");
        System.out.println("|---Your ticket is generated and vehicle is parked---|");
        System.out.println("|--Vehicle number: "+vehicle.getVehicleId() + "-------------------------------|");
        System.out.println("|--Parking space id: "+ticket.getParkingSpace().getParkingSpaceId() +  "-------------------------------|");
        System.out.println("|----------------------------------------------------|");
    }
}
