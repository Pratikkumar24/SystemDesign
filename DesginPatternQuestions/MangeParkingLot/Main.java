package MangeParkingLot;

import MangeParkingLot.parkingManager.ParkingManager;
import MangeParkingLot.strategy.paymentStrategy.CardPayment;
import MangeParkingLot.strategy.paymentStrategy.Payment;
import MangeParkingLot.strategy.paymentStrategy.UpiPayment;
import MangeParkingLot.ticket.Ticket;
import MangeParkingLot.vehicle.ThreeWheeler;
import MangeParkingLot.vehicle.TwoWheeler;

public class Main {
    public static void main(String[] args) {
        ParkingManager manager = new ParkingManager();
        
        Ticket ticket1 = manager.getTicket(new TwoWheeler(12));
        Payment upi1 = new UpiPayment("pratik@UPI2000");

        Ticket ticket2 = manager.getTicket(new TwoWheeler(11));
        Payment upi2 = new UpiPayment("rahul@Upi2387");

        Ticket ticket3 = manager.getTicket(new TwoWheeler(1354));
        Payment card1 = new CardPayment(12334, 23, 12);

        Ticket ticket4 = manager.getTicket(new ThreeWheeler(133));
        Payment card2 = new CardPayment(5344, 13, 2);

        Ticket ticket5 = manager.getTicket(new ThreeWheeler(4));
        Payment card3 = new CardPayment(7648, 3, 1999);

        // Ticket ticket6 = manager.getTicket(new ThreeWheeler(41));
        // Payment card4 = new CardPayment(9080, 1, 2000);

        // Ticket ticket7 = manager.getTicket(new FourWheeler(4));
        // Payment card5 = new CardPayment(6644, 23, 1444);

        // Ticket ticket8 = manager.getTicket(new FourWheeler(4));
        // Payment upi3 = new UpiPayment("roshan342342@UPI");

        manager.exitVehicle(ticket1, upi1);
        manager.exitVehicle(ticket2, upi2);
        manager.exitVehicle(ticket3, card1);
        manager.exitVehicle(ticket4, card2);
        manager.exitVehicle(ticket5, card3);
        // manager.exitVehicle(ticket6, card4);
        // manager.exitVehicle(ticket7, card5);
        // manager.exitVehicle(ticket8, upi3);
    }
}
