package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    public static final void main(String[] args) throws ParseException {

        Flight f1 = new Flight(122, "Milan", "Fquih ben salah", "2013.01.12 04:16:00", "2013.01.12 15:16:00", 1, 3, 2,
                3);
        System.out.println(f1.getDepartDate() + "\t" + f1.getArrivingDate() + "\t" + f1.getDuration());
    }

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
    private int airlineID;
    private int apID;
    private int airplaneID;
    private int pilotID;

    /** Constructors */
    public Flight() {};
    public Flight(int flightID, String source, String destination, String departString, String arrivingString,
            int airlineID, int apID, int airplaneID, int pilotID) throws ParseException {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = setDepartDate(departString);
        this.arrivingDate = setArrivingDate(arrivingString);
        this.duration = duration();
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate, int terminal,
            String status, String flightType, 
            int airlineID, int apID, int airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration();
        this.terminal = terminal;
        this.status = status;
        this.flightType = flightType;
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate, int terminal,
            String status, String flightType, ArrayList<Passenger> passengers,
            int airlineID, int apID, int airplaneID, int pilotID) {
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
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }

    /* Getters And Setters */
    public int getPilotID() {
        return pilotID;
    }
    
    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public int getApID() {
        return apID;
    }

    public void setApID(int apID) {
        this.apID = apID;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getArrivingDate() {
        return arrivingDate;
    }

    public Date setArrivingDate(String arrivingString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Date arriving = formatter.parse(arrivingString);
        return arriving;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public Date setDepartDate(String departString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Date depart = formatter.parse(departString);
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Passenger> getpassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = (ArrayList<Passenger>) passengers;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
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

        return  Duration.parse(durationString);

    }
            
}
