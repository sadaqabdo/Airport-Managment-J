package classes;

public class Employee extends Person{

    public Employee(int id, String name, int age, String gender, String nationality) {
        super(id, name, age, gender, nationality);
    }

    public Employee(int id, String name, int age, String nationality) {
        super(id, name, age, nationality);
    }

    public Employee(int id, String name) {
        super(id, name);
    }


}