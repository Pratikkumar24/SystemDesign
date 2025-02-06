package SystemDesign.DesginPatternQuestions.tickettransition;

import SystemDesign.DesginPatternQuestions.tickettransition.service.TicketService;;
public class Main {
    public static void main(String[] args) {
        Users user1 = new Users("User1");
        Users user2 = new Users("User2");
        TicketService ticketService = new TicketService();
        Ticket ticket1 = ticketService.createTicket("user1 description", user1);
        Ticket ticket2 = ticketService.createTicket("user2 description", user2);

        ticketService.startAnalysis(ticket1, user1);
        ticketService.startReview(ticket1, user1);
        ticketService.markDone(ticket1, user1);

        ticketService.startAnalysis(ticket2, user2);
        ticketService.startReview(ticket2, user2);
        ticketService.markDone(ticket2, user2);

        ticketService.startAnalysis(ticket1, user1);
    }
}
