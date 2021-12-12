package classes;

public class Employee extends Person {
    private String job;
    //Constructor

    //default Constructor
    public Employee() {
    }

    // Constructors
    public Employee(int id, String name, int age, String gender, String nationality, String job) {
        super(id, name, age, gender, nationality);
        this.job = job;
    }


    public Employee(int id, String name, int age, String nationality) {
        super(id, name, age, nationality);
    }

    public Employee(int id, String name) {
        super(id, name);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}

/*
public class Employee{

    private int id;
    private String name;
    private String job;

    //default Constructor
    public Employee(){

    }
    //Constructor
    public Employee(int id, String name, String job){
        this.id=id;
        this.name=name;
        this.job=job;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }
}
*/



