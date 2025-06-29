package fa.training.entities;

import java.util.Date;

public class Teacher extends Person {
    private double basicSalary;
    private double subsidy;

    public Teacher() {
        super();
    }

    public Teacher(String fullName, String gender, String phone, String email, Date birthDate,
                   double basicSalary, double subsidy) {
        super(fullName, gender, phone, email, birthDate);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher Information:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Basic Salary: $" + basicSalary);
        System.out.println("Subsidy: $" + subsidy);
        System.out.println("Total Salary: $" + calculateSalary());
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "basicSalary=" + basicSalary +
                ", subsidy=" + subsidy +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
} 