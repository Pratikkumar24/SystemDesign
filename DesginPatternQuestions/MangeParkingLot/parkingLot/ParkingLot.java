package MangeParkingLot.parkingLot;

import java.util.ArrayList;
import java.util.List;

import MangeParkingLot.parkingGate.EntranceGate;
import MangeParkingLot.parkingGate.ExitGate;
import MangeParkingLot.parkingSpace.ParkingSpace;
import MangeParkingLot.strategy.paymentStrategy.Payment;
import MangeParkingLot.ticket.Ticket;
import MangeParkingLot.vehicle.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpace> twoWheelerParkingSpace;
    private List<ParkingSpace> threeWheelerParkingSpace;
    private List<ParkingSpace> fourWheelerParkingSpace;
    private ParkingVehicleData parkingVehicleData;
    private EntranceGate entranceGate;
    private ExitGate exitGate;

    private ParkingLot(){}

    public static ParkingLot getParkingInstance() {
        if (instance == null) {
            synchronized(ParkingLot.class) {
                instance = new ParkingLot();
            }
        }
        return instance;
    }

    public void initilizeParkingLot() {
        entranceGate = new EntranceGate();
        exitGate = new ExitGate();
        parkingVehicleData = new ParkingVehicleData();
        twoWheelerParkingSpace = new ArrayList<>();
        initializeParkingSpace(parkingVehicleData.getTwoWheelerSize(), twoWheelerParkingSpace);

        threeWheelerParkingSpace = new ArrayList<>();
        initializeParkingSpace(parkingVehicleData.getThreeWheelerSize(), threeWheelerParkingSpace);

        fourWheelerParkingSpace = new ArrayList<>();
        initializeParkingSpace(parkingVehicleData.getFourWheelerSize(), fourWheelerParkingSpace);
    }

    private void initializeParkingSpace(int size, List<ParkingSpace> vehicleParkingSpace) {
        for(int i=0; i<size; i++) {
            vehicleParkingSpace.add(new ParkingSpace(i));
        }
    }

    private ParkingSpace getParkingSpace(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case TWO_WHEELER:
                for(int i=0; i<parkingVehicleData.getTwoWheelerSize(); i++) {
                    if(twoWheelerParkingSpace.get(i).getVehicle() == null) {
                        twoWheelerParkingSpace.get(i).setVehicle(vehicle);
                        return twoWheelerParkingSpace.get(i);
                    }
                }
                return null;
            case THREE_WHEELER:
                for(int i=0; i<parkingVehicleData.getThreeWheelerSize(); i++) {
                    if(threeWheelerParkingSpace.get(i).getVehicle() == null) {
                        threeWheelerParkingSpace.get(i).setVehicle(vehicle);
                        return threeWheelerParkingSpace.get(i);
                    }
                }
                return null;
            case FOUR_WHEELER:
                for(int i=0; i<parkingVehicleData.getFourWheelerSize(); i++) {
                    if(fourWheelerParkingSpace.get(i).getVehicle() == null) {
                        fourWheelerParkingSpace.get(i).setVehicle(vehicle);
                        return fourWheelerParkingSpace.get(i);
                    }
                }
                return null;
            default:
                return null;
        }
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpace space = getParkingSpace(vehicle);
        return entranceGate.generateTicket(vehicle, space);
    }

    public void payAmount(Ticket ticket, Payment paymentMethod) {
        int parkingSpaceId = exitGate.exit(ticket, paymentMethod);
        switch (ticket.getVehicle().getVehicleType()) {
            case TWO_WHEELER:
                twoWheelerParkingSpace.get(parkingSpaceId).removeVehicle();
                break;
            case THREE_WHEELER:
                threeWheelerParkingSpace.get(parkingSpaceId).removeVehicle();
                break;
            case FOUR_WHEELER:
                fourWheelerParkingSpace.get(parkingSpaceId).removeVehicle();
                break;
            default:
                break;
        }
    }
}
