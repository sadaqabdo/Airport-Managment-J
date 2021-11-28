package classes;

public class Airplane{
    private int airplaneID;
    private int capacity;

    public Airplane(int airplaneID, int capacity){
        this.airplaneID = airplaneID;
        this.capacity = capacity;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getAirplaneID() {
        return airplaneID;
    }
    public int getCapacity() {
        return capacity;
    }
}