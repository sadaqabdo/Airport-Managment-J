package classes;

public class Admin extends Employee{
    private String userName;
    private String password;
    //default Constructor
    public Admin(){

    }
    //Constructor
    public Admin(int id, String name, int age, String gender, String nationality, String job, String userName, String password){
        super(id, name, age, gender, nationality, job);
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword(){return password;}

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
}