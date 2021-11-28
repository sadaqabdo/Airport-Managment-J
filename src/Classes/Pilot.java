package Classes;


public class Pilot 
{
    private int pilot_id;
    private String pilot_name;
    private String gender;
    private String status;

    public Pilot( int pilot_id, String pilot_name, String gender, String status )
    {
        this.pilot_id       = pilot_id;
        this.pilot_name     = pilot_name;
        this.gender         = gender;
        this.status         = status;
    }
    public int getPilotId()
    {
        return pilot_id;
    }
    public String getPilotName()
    {
        return pilot_name;
    }
    public String getGender()
    {
        return gender;
    }
    public String getStatus()
    {
        return status;
    }


    
    public void setPilotId(int pilot_id)
    {
        this.pilot_id = pilot_id;
    }

    public void setPilotName(String pilot_name)
    {
        this.pilot_name = pilot_name;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}