package tickettransition.service;

import tickettransition.Ticket;
import tickettransition.Users;

public class TicketService {
    public Ticket createTicket(String description, Users createdBy) {
        return new Ticket(description, createdBy);
    }

    public void startAnalysis(Ticket ticket, Users user) {
        ticket.getTicketState().startAnalysis(ticket, user);
    }

    public void startReview(Ticket ticket, Users user) {
        ticket.getTicketState().startReview(ticket, user);
    }

    public void markDone(Ticket ticket, Users user) {
        ticket.getTicketState().markDone(ticket, user);
    }
}
