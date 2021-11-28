package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Flight {
    public static final void main(String[] args) throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String departureString = "2013.01.12 04:12:23";
        String arrivalString = "2013.01.12 15:16:00";

        Date departure = formatter.parse(departureString);
        Date arriving = formatter.parse(arrivalString);

        Duration duration = Flight.duration(departure, arriving);

        Flight f1 = new Flight(122,"Milan","Fquih ben salah", departure, arriving,duration,"nontype","going",1,3,2,3);
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
    
    /**Constructors */
    public Flight(){};
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate,
    Duration duration, int airlineID, int apID, int airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration;
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
}
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate, Duration duration,
            String status, String flightType, int airlineID, int apID, int airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration;
        this.status = status;
        this.setFlightType(flightType);
        this.setAirlineID(airlineID);
        this.setApID(apID);
        this.setAirplaneID(airplaneID);
        this.setPilotID(pilotID);
    }
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate,
            Duration duration, String status, String flightType, List<Passenger> passengers, int airlineID, int apID,
            int airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration;
        this.status = status;
        this.flightType = flightType;
        this.setPassengers(passengers);
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }
    public Flight(int flightID, String source, String destination, Date departDate, Date arrivingDate,
            Duration duration, int terminal, String status, String flightType, List<Passenger> passengers,
            int airlineID, int apID, int airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration;
        this.terminal = terminal;
        this.status = status;
        this.flightType = flightType;
        this.passengers = (ArrayList<Passenger>) passengers;
        this.airlineID = airlineID;
        this.apID = apID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }

    /*Getters And Setters*/
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
    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }
    public Date getDepartDate() {
        return departDate;
    }
    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
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

    /**Duration Method  */
    static Duration duration(Date startDate, Date endDate) { 
       
            long differenceInTime = endDate.getTime() - startDate.getTime();

            long differenceInSeconds = (differenceInTime / 1000) % 60;

            long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;

            long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24;
            long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;

            String durationString = "P"+Long.toString(differenceInDays)+"DT"+Long.toString(differenceInHours)+"H"+Long.toString(differenceInMinutes)+"M"+Long.toString(differenceInSeconds)+"S";
            Duration duration = Duration.parse(durationString);
            return duration;
    
        }    
}
