package classes;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private String flightID;
    private String source;
    private String destination;
    private Date departDate;
    private Date arrivingDate;
    private String duration;
    private String terminal;
    private String flightType;
    private String airportID;
    private String airplaneID;
    private int pilotID;

    /**
     * Constructors
     */
    public Flight() {
    }

    public Flight(String source, String destination, String departString, String arrivingString,
                  String terminal, String airplaneID, int pilotID) throws ParseException {
        setFlightID();
        setSource(source);
        setDestination(destination);
        setDepartDate(departString);
        setArrivingDate(arrivingString);
        this.duration = duration();
        setTerminal(terminal);
        setAirplaneID(airplaneID);
        setPilotID(pilotID);
    }
    public Flight(String flightID, String source, String destination, String departString, String arrivingString,
                       String airportID, String airplaneID, int pilotID) throws ParseException {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        setDepartDate(departString);
        setArrivingDate(arrivingString);
        this.duration = duration();
        this.airportID = airportID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }

    public Flight(String flightID, String source, String destination, Date departDate, Date arrivingDate,
                  String terminal, String airportID,
                  String airplaneID, int pilotID) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivingDate = arrivingDate;
        this.duration = duration();
        this.terminal = terminal;
        this.airportID = airportID;
        this.airplaneID = airplaneID;
        this.pilotID = pilotID;
    }

    /**
     * StringMethod
    static String duration(Date startDate, Date endDate) {
        long differenceInTime = endDate.getTime() - startDate.getTime();
        long differenceInSeconds = (differenceInTime / 1000) % 60;
        long differenceInMinutes = (differenceInTime / (1000 * 60)) % 60;
        long differenceInHours = (differenceInTime / (1000 * 60 * 60)) % 24;
        long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
        String durationString = "P" + differenceInDays + "DT" + differenceInHours + "H"
                + differenceInMinutes + "M" + differenceInSeconds + "S";
        return Duration.parse(durationString);
    }*/

    /* Getters And Setters */
    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public Integer getPilotID() {
        return pilotID;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public void setArrivingDate(String arrivingString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        SimpleDateFormat formatter4 = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss");
        arrivingString.strip();
        try {
            try {
                this.arrivingDate = formatter4.parse(arrivingString);
            }
            catch (ParseException r){
            this.arrivingDate = formatter.parse(arrivingString);
        }}catch (ParseException e){
            try{
                this.arrivingDate = formatter3.parse(arrivingString);
            }catch (ParseException l) {
                this.arrivingDate = formatter2.parse(arrivingString);
            }
        }

    }

    public void setDepartDate(String departString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        SimpleDateFormat formatter4 = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss");

        departString.strip();
        try {
            try {
                this.departDate = formatter.parse(departString);
            }catch (ParseException l ){
                this.departDate = formatter4.parse(departString);
            }
        }catch (ParseException e){
            try {
                this.departDate = formatter2.parse(departString);
            }catch (ParseException l){
                this.departDate = formatter3.parse(departString);

            }
        }

    } 

    public String duration() {
        long differenceInTime = this.arrivingDate.getTime() - this.departDate.getTime();

        long differenceInSeconds = Math.abs((differenceInTime / 1000) % 60);
        long differenceInMinutes = Math.abs((differenceInTime / (1000 * 60)) % 60);
        long differenceInHours = Math.abs((differenceInTime / (1000 * 60 * 60)) % 24);
        long differenceInDays = Math.abs((differenceInTime / (1000 * 60 * 60 * 24)) % 365);

        String DurationString = differenceInHours + "h"
                + differenceInMinutes + "m" + differenceInSeconds + "s";

        if (differenceInDays != 0 ) {
            DurationString = differenceInDays + "D" + differenceInHours + "h"
                    + differenceInMinutes + "m" + differenceInSeconds + "s";
        }
        return DurationString;
    }
    public void setFlightID() {
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String A1 = "0123456789";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 2; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
            sb.append(A1.charAt(rnd.nextInt(A1.length())));
        }
        this.flightID = sb.toString();
    }}