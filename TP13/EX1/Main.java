package TP13;

import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        List<Employer> staff = new ArrayList<>();
        staff.add(new Employer(1, "Marwan", 3000.0, "pwd1"));
        staff.add(new Employer(2, "Fatima", 3500.5, "pwd2"));
 
        Serial.serial("employees.ser", staff);
 
        List<Employer> loaded = Serial.serial("employees.ser");
 
        for (Employer emp : loaded) {
            System.out.println(emp);
        }
    }
 
}