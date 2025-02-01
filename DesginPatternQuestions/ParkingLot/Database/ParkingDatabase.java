package Database;

import java.util.HashMap;
import java.util.HashSet;

import Database.DatabaseInterface.parkingSpotInterface;
import Database.DatabaseInterface.ticketInterface;
import Database.DatabaseInterface.vehicleInterface;
import Entities.ParkingSpot;
import interfaces.Vehicle;

public final class ParkingDatabase implements vehicleInterface, parkingSpotInterface, ticketInterface {
    
    public static ParkingDatabase instances;

    //Datastructures to store the data
    private HashSet<Integer> vehicleIds;
    private HashSet<Integer> parkingSpotIds;
    private HashSet<Integer> ticketIds;
    private HashMap<Integer, Vehicle> parkingSpotToVehicleMap;
    private HashMap<Integer, ParkingSpot> ticketNumberToParkingSpotMap;

    private ParkingDatabase() {}

    public void initialParkingDatabase() {
        init();
    }

    private void init() {
        vehicleIds = new HashSet<>();
        parkingSpotIds = new HashSet<>();
        ticketIds = new HashSet<>();
        ticketNumberToParkingSpotMap = new HashMap<>();
        parkingSpotToVehicleMap = new HashMap<>();
    }

    public static ParkingDatabase getInstances() {
        if(instances == null) {
            synchronized (ParkingDatabase.class) {
                if(instances == null) {
                    instances = new ParkingDatabase();
                }
            }
        }
        return instances;
    }

    @Override
    public boolean isVehicleIdPresent(int id) {
        return vehicleIds.contains(id);
    }

    @Override
    public void addVehicleId(int id) {
        vehicleIds.add(id);
    }

    @Override
    public void removeVehicleId(int id) {
        vehicleIds.remove(id);
    }

    @Override
    public boolean isParkingSpotPresent(int id) {
        return parkingSpotIds.contains(id);
    }

    @Override
    public void removeParkingSpotId(int id) {
        parkingSpotIds.remove(id);
    }

    @Override
    public void addParkingSpotId(int id) {
        parkingSpotIds.add(id);
    }

    @Override
    public void addVehicleToParkingSpot(int parkingSpotId, Vehicle vehicle) {
        parkingSpotToVehicleMap.put(parkingSpotId, vehicle);    
    }

    @Override
    public void removeVehicleFromParkingSpot(int parkingSpotId) {
        parkingSpotToVehicleMap.remove(parkingSpotId);
    }

    @Override
    public boolean isTicketIdPresent(int id) {
        return ticketIds.contains(id);
    }

    @Override
    public void removeTicketId(int id) {
        ticketIds.remove(id);
    }

    @Override
    public void addTicketId(int id) {
        ticketIds.add(id);
    }

    @Override
    public void addTicketIdToParkingSpot(int ticketId, ParkingSpot parkingSpot) {
        ticketNumberToParkingSpotMap.put(ticketId, parkingSpot);
    }

    @Override
    public void removeTicketIdToParkingSpot(int ticketId) {
        ticketNumberToParkingSpotMap.remove(ticketId);
    }

}
