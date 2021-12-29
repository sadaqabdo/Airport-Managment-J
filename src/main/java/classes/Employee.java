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

    public Employee(String name, int age, String gender, String nationality, String job) {
        super(name,age,gender,nationality);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}




