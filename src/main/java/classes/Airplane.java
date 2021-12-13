package classes;

public class Airplane {

    private int airplaneID;
    private int capacity;
    private Airline airline;

    public Airplane(int airplaneID, int capacity, Airline airline) {
        this.airplaneID = airplaneID;
        this.capacity = capacity;
        this.airline = airline;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }


}