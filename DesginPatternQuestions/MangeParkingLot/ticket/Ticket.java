package MangeParkingLot.ticket;

import MangeParkingLot.parkingSpace.ParkingSpace;
import MangeParkingLot.vehicle.Vehicle;

public class Ticket {
    /**
     * @param vehicle: Exit gate will calculate the price per unit of time for particular vehicle.
     * @param parkingSpace: Exit gate will free this space area
     * @param entranceTime: Exit gate will calculate how much time this vehicle has taken over all
     */
    private Vehicle vehicle;
    private ParkingSpace parkingSpace;
    private long entranceTime;

    public Ticket(Vehicle vehicle, ParkingSpace parkingSpace) {
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        entranceTime = System.currentTimeMillis();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public long getEntranceTime() {
        return entranceTime;
    }
}
