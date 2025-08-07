package pack2;

import java.time.LocalDate;
import java.time.Period;

public class Lab15 {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    
    public Lab15(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth, today);
        return period.getYears();
    }

   
    public String getFullName() {
        return firstName + " " + lastName;
    }


    public void displayPersonDetails() {
        System.out.println("Full Name: " + getFullName());
        System.out.println("Age: " + calculateAge() + " years");
    }
}
