package classes;

public class Ticket {
    private int ticketID;
    private Passenger passenger;
    private Flight flight;

    public Ticket(int ticketID, Passenger passenger, Flight flight) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.flight = flight;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
