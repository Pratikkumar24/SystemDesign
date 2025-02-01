package Database.DatabaseInterface;

public interface vehicleInterface {
    boolean isVehicleIdPresent(int id);
    void removeVehicleId(int id);
    void addVehicleId(int id);
}
