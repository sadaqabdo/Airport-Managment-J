package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private int flightID;
    private String source;
    private String destination;
    private Date departDate;
    private Date arrivingDate;
    private Duration duration;
    private int terminal;
    private String status;
    private String flightType;
    private ArrayList<Passenger> passengers;
    private Airline airline;
    private Airport airport;
    private Airplane airplane;
    private Pilot pilot;

    /** Constructors */
    public Flight() {
    }

    public Flight(int flightID, String source, String destination, String departString, String arrivingString,
            Airline airline, Airport airport, Airplane airplane, Pilot pilot) throws ParseException {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = setDepartDate(departString);
        this.arrivingDate = setArrivingDate(arrivingString);
        this.duration = duration();
        this.airline = airline;
        this.airport = airport;
        this.airplane = airplane;
        this.pilot = pilot;
    }

    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate,
            int terminal, String status, String flightType, ArrayList<Passenger> passengers,
            Airline airline, Airport airport, Airplane airplane, Pilot pilot) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration();
        this.terminal = terminal;
        this.status = status;
        this.flightType = flightType;
        this.passengers = passengers;
        this.airline = airline;
        this.airport = airport;
        this.airplane = airplane;
        this.pilot = pilot;
    }

    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate,
            int terminal, String status, String flightType, Airline airline, Airport airport,
            Airplane airplane, Pilot pilot) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration();
        this.terminal = terminal;
        this.status = status;
        this.flightType = flightType;
        this.airline = airline;
        this.airport = airport;
        this.airplane = airplane;
        this.pilot = pilot;
    }

    /* Getters And Setters */
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Date setArrivingDate(String arrivingString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Date arriving = formatter.parse(arrivingString);
        return arriving;
    }

    public Date setDepartDate(String departString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Date depart = formatter.parse(departString);
        return depart;
    }

    /** Duration Method */
    static Duration duration(Date startDate, Date endDate) {
        long differenceInTime = endDate.getTime() - startDate.getTime();

        long differenceInSeconds = (differenceInTime / 1000) % 60;
        long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;
        long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24;
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        String durationString = "P" + Long.toString(differenceInDays) + "DT" + Long.toString(differenceInHours) + "H"
                + Long.toString(differenceInMinutes) + "M" + Long.toString(differenceInSeconds) + "S";

        return Duration.parse(durationString);
    }

    public Duration duration() {
        long differenceInTime = this.arrivingDate.getTime() - this.departDate.getTime();

        long differenceInSeconds = (differenceInTime / 1000) % 60;
        long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;
        long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24;
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

        String durationString = "P" + Long.toString(differenceInDays) + "DT" + Long.toString(differenceInHours) + "H"
                + Long.toString(differenceInMinutes) + "M" + Long.toString(differenceInSeconds) + "S";

        return Duration.parse(durationString);

    }
}
