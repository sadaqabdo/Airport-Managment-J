package Classes;


public class Airplane 
{
    private int airplane_id;
    private int capacity;


    public Airplane( int airplane_id, int capacity )
    {
        this.airplane_id  = airplane_id;
        this.capacity     = capacity;
    }
    public int getAirplaneId()
    {
        return airplane_id;
    }
    public int getCapacity()
    {
        return capacity;
    }
    

    
    public void setAirplaneId(int airplane_id)
    {
        this.airplane_id  = airplane_id;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

}