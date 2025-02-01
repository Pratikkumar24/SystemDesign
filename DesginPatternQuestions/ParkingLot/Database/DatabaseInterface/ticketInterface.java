package Database.DatabaseInterface;

import Entities.ParkingSpot;

public interface ticketInterface {
    boolean isTicketIdPresent(int id);
    void removeTicketId(int id);
    void addTicketId(int id);
    void addTicketIdToParkingSpot(int ticketId, ParkingSpot parkingSpot);
    void removeTicketIdToParkingSpot(int ticketId);
}
