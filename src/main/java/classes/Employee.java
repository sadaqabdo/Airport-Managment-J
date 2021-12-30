package classes;

public class Employee extends Person {
    private String job;
    private int salary;
    private String password;
    //Constructor

    //default Constructor
    public Employee() {
    }

    // Constructors
    public Employee(int id, String name, int age, String gender, String nationality, String job) {
        super(id, name, age, gender, nationality);
        this.job = job;
    }

    public Employee(int id, String name) {
        super(id, name);
    }

    public Employee(String name, int age, String gender, String nationality, String job) {
        super(name,age,gender,nationality);
        this.job = job;
    }
    public Employee(int id, String name, int salary, String password) {
        super(id, name);
        this.salary = salary;
        this.password=password;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public int getSalary() {
        return salary;
    }
    public String getPassword() {
        return password;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}




