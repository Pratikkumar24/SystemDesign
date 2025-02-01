package Database.DatabaseInterface;

import interfaces.Vehicle;

public interface parkingSpotInterface {
    boolean isParkingSpotPresent(int id);
    void removeParkingSpotId(int id);
    void addParkingSpotId(int id);
    void addVehicleToParkingSpot(int parkingSpotId, Vehicle vehicle);
    void removeVehicleFromParkingSpot(int parkingSpotId);
}
