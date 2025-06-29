package fa.training.entities;

import java.util.Date;

public class Student extends Person {
    private String studentId;
    private double theory;
    private double practice;

    public Student() {
        super();
    }

    public Student(String fullName, String gender, String phone, String email, Date birthDate,
                   String studentId, double theory, double practice) {
        super(fullName, gender, phone, email, birthDate);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    public double calculateFinalMark() {
        return (theory + practice) / 2.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Information:");
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Theory Mark: " + theory);
        System.out.println("Practice Mark: " + practice);
        System.out.println("Final Mark: " + calculateFinalMark());
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", theory=" + theory +
                ", practice=" + practice +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
} 