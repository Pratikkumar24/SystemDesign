package SystemDesign.DesginPatternQuestions.tickettransition.ticketstate;

import SystemDesign.DesginPatternQuestions.tickettransition.Ticket;
import SystemDesign.DesginPatternQuestions.tickettransition.Users;

public interface State {
    boolean startAnalysis(Ticket ticket, Users user);
    boolean startReview(Ticket ticket, Users user);
    boolean markDone(Ticket ticket, Users user);
}
