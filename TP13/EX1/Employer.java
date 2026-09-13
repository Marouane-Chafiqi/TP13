package TP13;

import java.io.Serializable;

public class Employer implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    int id;
    String name;
    double salary;
    transient String password;
 
    public Employer(int id, String name, double salary, String password) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.password = password;
    }
 
    public String toString() {
        return "Employer[id=" + id + ", name=" + name + ", salary=" + salary + ", password=" + password + "]";
    }
 
}
 