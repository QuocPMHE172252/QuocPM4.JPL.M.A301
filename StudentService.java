package fa.training.services;

import fa.training.entities.Student;
import fa.training.utils.Validator;
import java.util.Date;
import java.util.Scanner;

public class StudentService {
    private static Scanner scanner = new Scanner(System.in);
    
    public static Student inputStudent() {
        System.out.println("\n=== INPUT STUDENT DATA ===");
        
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        
        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (!Validator.isValidEmail(email)) {
                System.out.println("Invalid email format! Please try again.");
            }
        } while (!Validator.isValidEmail(email));
        
        Date birthDate;
        do {
            System.out.print("Enter birth date (dd/MM/yyyy): ");
            String birthDateStr = scanner.nextLine();
            birthDate = Validator.parseDate(birthDateStr);
            if (birthDate == null) {
                System.out.println("Invalid date format! Please use dd/MM/yyyy.");
            }
        } while (birthDate == null);
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        double theory;
        do {
            System.out.print("Enter theory mark (0-10): ");
            theory = getDoubleInput();
            if (!Validator.isValidMark(theory)) {
                System.out.println("Invalid mark! Must be between 0 and 10.");
            }
        } while (!Validator.isValidMark(theory));
        
        double practice;
        do {
            System.out.print("Enter practice mark (0-10): ");
            practice = getDoubleInput();
            if (!Validator.isValidMark(practice)) {
                System.out.println("Invalid mark! Must be between 0 and 10.");
            }
        } while (!Validator.isValidMark(practice));
        
        Student student = new Student(fullName, gender, phone, email, birthDate, studentId, theory, practice);
        System.out.println("Student added successfully!");
        return student;
    }
    
    public static void updateStudent(Student[] students, int studentCount) {
        if (studentCount == 0) {
            System.out.println("No students in the system!");
            return;
        }

        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getStudentId().equals(studentId)) {
                found = true;
                System.out.println("Found student: " + students[i].getFullName());
                System.out.println("Current data:");
                students[i].displayInfo();
                
                System.out.println("\n=== UPDATE STUDENT DATA ===");
                System.out.print("Enter new full name (or press Enter to keep current): ");
                String fullName = scanner.nextLine();
                if (!fullName.trim().isEmpty()) {
                    students[i].setFullName(fullName);
                }
                
                System.out.print("Enter new gender (or press Enter to keep current): ");
                String gender = scanner.nextLine();
                if (!gender.trim().isEmpty()) {
                    students[i].setGender(gender);
                }
                
                System.out.print("Enter new phone (or press Enter to keep current): ");
                String phone = scanner.nextLine();
                if (!phone.trim().isEmpty()) {
                    students[i].setPhone(phone);
                }
                
                String email;
                do {
                    System.out.print("Enter new email (or press Enter to keep current): ");
                    email = scanner.nextLine();
                    if (email.trim().isEmpty()) {
                        break;
                    }
                    if (!Validator.isValidEmail(email)) {
                        System.out.println("Invalid email format! Please try again.");
                    } else {
                        students[i].setEmail(email);
                        break;
                    }
                } while (true);
                
                System.out.print("Enter new theory mark (or -1 to keep current): ");
                double theory = getDoubleInput();
                if (theory != -1 && Validator.isValidMark(theory)) {
                    students[i].setTheory(theory);
                }
                
                System.out.print("Enter new practice mark (or -1 to keep current): ");
                double practice = getDoubleInput();
                if (practice != -1 && Validator.isValidMark(practice)) {
                    students[i].setPractice(practice);
                }
                
                System.out.println("Student updated successfully!");
                System.out.println("Updated data:");
                students[i].displayInfo();
                break;
            }
        }
        
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found!");
        }
    }
    
    public static void displayPassingStudents(Student[] students, int studentCount) {
        if (studentCount == 0) {
            System.out.println("No students in the system!");
            return;
        }

        System.out.println("\n=== PASSING STUDENTS (Final Mark >= 6) ===");
        boolean found = false;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].calculateFinalMark() >= 6) {
                System.out.println("Student ID: " + students[i].getStudentId());
                System.out.println("Full Name: " + students[i].getFullName());
                System.out.println("Final Mark: " + students[i].calculateFinalMark());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No passing students found!");
        }
    }
    
    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
} 