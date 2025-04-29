package tickettransition.ticketstate;

import tickettransition.Ticket;
import tickettransition.Users;

public interface State {
    boolean startAnalysis(Ticket ticket, Users user);
    boolean startReview(Ticket ticket, Users user);
    boolean markDone(Ticket ticket, Users user);
}
