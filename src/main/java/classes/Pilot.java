package classes;

public class Pilot extends Person {

    private int pilotID;
    private String status;
    private int airlineID;

    public Pilot(int id, String name, int age, String gender, String nationality, int pilotID, String status,
                 int airlineID) {
        super(id, name, age, gender, nationality);
        this.pilotID = pilotID;
        this.status = status;
        this.airlineID = airlineID;
    }

    public Pilot(int id, String name, int age, String nationality, int pilotID, String status, int airlineID) {
        super(id, name, age, nationality);
        this.pilotID = pilotID;
        this.status = status;
        this.airlineID = airlineID;
    }

    public Pilot(int id, String name, int pilotID, String status, int airlineID) {
        super(id, name);
        this.pilotID = pilotID;
        this.status = status;
        this.airlineID = airlineID;
    }

    public int getPilotID() {
        return pilotID;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }


}