package SystemDesign.DesginPatternQuestions.tickettransition;

public class TicketService {
    public Ticket createTicket(String description, Users createdBy) {
        return new Ticket(description, createdBy);
    }

    public void changeTicketStatus(Ticket ticket, TicketStatus status) {
        TicketStatus currentStatus = ticket.getStatus();

        if(currentStatus.equals(TicketStatus.ANALYSIS)) {
            if(status.equals(TicketStatus.REVIEW)) {
                ticket.setStatus(status);
                System.out.println("[+] Ticket moved to REVIEW state of user: " + ticket.getCreatedBy().name);
            } else if(status.equals(TicketStatus.DONE)) {
                ticket.setStatus(status);
                System.out.println("[+] Ticket moved to DONE state of user: " + ticket.getCreatedBy().name);
            } else {
                System.out.println("[X] Invalid state transition of user: " + ticket.getCreatedBy().name);
            }
        }
        if(currentStatus.equals(TicketStatus.REVIEW)) {
            if(status.equals(TicketStatus.DONE)) {
                ticket.setStatus(status);
                System.out.println("[+] Ticket moved to DONE state of user: " + ticket.getCreatedBy().name);
            } else if(status.equals(TicketStatus.ANALYSIS)) {
                ticket.setStatus(status);
                System.out.println("[-] Ticket moved to ANALYSIS state of user: " + ticket.getCreatedBy().name);
            } else {
                System.out.println("[X] Invalid state transition of user: " + ticket.getCreatedBy().name);
            }
        }

        if(currentStatus.equals(TicketStatus.DONE)) {
            if(status.equals(TicketStatus.ANALYSIS)) {
                ticket.setStatus(status);
                System.out.println("[-] Ticket moved to ANALYSIS state of user: " + ticket.getCreatedBy().name);
            } else if(status.equals(TicketStatus.REVIEW)) {
                ticket.setStatus(status);
                System.out.println("[-] Ticket moved to REVIEW state of user : " + ticket.getCreatedBy().name);
            } else {
                System.out.println("[X] Invalid state transition of user: " + ticket.getCreatedBy().name);
            }
        }
    }
}
