package SystemDesign.DesginPatternQuestions.tickettransition;

public class Main {
    public static void main(String[] args) {
        Users user1 = new Users("User1");
        Users user2 = new Users("User2");
        TicketService ticketService = new TicketService();
        Ticket ticket1 = ticketService.createTicket("user1 description", user1);
        Ticket ticket2 = ticketService.createTicket("user2 description", user2);

        ticketService.changeTicketStatus(ticket1, TicketStatus.REVIEW);
        ticketService.changeTicketStatus(ticket1, TicketStatus.DONE);

        ticketService.changeTicketStatus(ticket2, TicketStatus.REVIEW);
        ticketService.changeTicketStatus(ticket2, TicketStatus.ANALYSIS);
        ticketService.changeTicketStatus(ticket2, TicketStatus.DONE);
        
    }
}
