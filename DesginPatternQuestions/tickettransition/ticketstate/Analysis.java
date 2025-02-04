package SystemDesign.DesginPatternQuestions.tickettransition.ticketstate;

import SystemDesign.DesginPatternQuestions.tickettransition.Ticket;
import SystemDesign.DesginPatternQuestions.tickettransition.Users;

public class Analysis implements State {

    @Override
    public boolean startAnalysis(Ticket ticket, Users user) {
        System.out.println("[X] Invalid state transition of user: " + ticket.getCreatedBy().getName());
        return false;   
    }

    @Override
    public boolean startReview(Ticket ticket, Users user) {
        System.out.println("[+] Ticket moved to REVIEW state of user: " + ticket.getCreatedBy().getName());
        ticket.setState(new Review());
        return true;
    }

    @Override
    public boolean markDone(Ticket ticket, Users user) {
        System.out.println("[+] Ticket moved to DONE state of user: " + ticket.getCreatedBy().getName());
        ticket.setState(new Done());
        return true;
    }
    
}
