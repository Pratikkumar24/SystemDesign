package tickettransition;

import tickettransition.ticketstate.State;
import tickettransition.ticketstate.Analysis;

public class Ticket {
    private String description;
    private State state;
    private Users createdBy;

    public Ticket(String description, Users createdBy) {
        this.description = description;
        this.state = new Analysis();
        this.createdBy = createdBy;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public State getTicketState() {
        return this.state;
    }

    public Users getCreatedBy() {
        return createdBy;
    }
}
