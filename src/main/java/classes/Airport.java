package classes;

public class Airport{
    private int apID;
    private String apName;
    private String city;
    private String country;

    public Airport(int apID, String apName, String city, String country) {
        this.apID = apID;
        this.apName = apName;
        this.city = city;
        this.country = country;
    }
    
    public void setApID(int apID) {
        this.apID = apID;
    }
    public int getApID() {
        return apID;
    }
    public void setApName(String apName) {
        this.apName = apName;
    }
    public String getApName() {
        return apName;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }

}