package classes;

public class Passenger extends Person {
    private Flight flight;
    private Ticket ticket;

    public Passenger(int id, String name, int age, String gender, String nationality, Flight flight, Ticket ticket) {
        super(id, name, age, gender, nationality);
        this.flight = flight;
        this.ticket = ticket;
    }

    public Passenger(int id, String name, int age, String nationality, Flight flight, Ticket ticket) {
        super(id, name, age, nationality);
        this.flight = flight;
        this.ticket = ticket;
    }

    public Passenger(int id, String name, Flight flight, Ticket ticket) {
        super(id, name);
        this.flight = flight;
        this.ticket = ticket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}
