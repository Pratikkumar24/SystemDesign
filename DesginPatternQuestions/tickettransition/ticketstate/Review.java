package tickettransition.ticketstate;

import tickettransition.Ticket;
import tickettransition.Users;

public class Review implements State {

    @Override
    public boolean startAnalysis(Ticket ticket, Users user) {
        System.out.println("[-] Ticket moved to ANALYSIS state of user: " + ticket.getCreatedBy().getName());
        ticket.setState(new Analysis());
        return true;
    }

    @Override
    public boolean startReview(Ticket ticket, Users user) {
        System.out.println("[X] Invalid state transition of user: " + ticket.getCreatedBy().getName());
        return false;
    }

    @Override
    public boolean markDone(Ticket ticket, Users user) {
        System.out.println("[+] Ticket moved to DONE state of user: " + ticket.getCreatedBy().getName());
        ticket.setState(new Done());
        return true;
    }
    
}
