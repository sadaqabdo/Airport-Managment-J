package classes;

public class Person {
    protected int id;
    private String name;   
    private int age;
    private String gender;
    private String nationality;
    
    public Person(int id, String name, int age, String gender, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }
    public Person(int id, String name, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}

