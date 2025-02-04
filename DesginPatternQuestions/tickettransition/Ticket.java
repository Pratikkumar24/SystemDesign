package SystemDesign.DesginPatternQuestions.tickettransition;

public class Ticket {
    private String description;
    private TicketStatus status;
    private Users createdBy;

    public Ticket(String description, Users createdBy) {
        this.description = description;
        this.status = TicketStatus.ANALYSIS;
        this.createdBy = createdBy;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Users getCreatedBy() {
        return createdBy;
    }
}
