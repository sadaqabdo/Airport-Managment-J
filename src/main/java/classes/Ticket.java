package classes;

public class Ticket {
    private String ticketID;
    private String passenger;
    private String flight;

    public Ticket(String ticketID, String passenger, String flight) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Ticket() {

    }


    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }


}