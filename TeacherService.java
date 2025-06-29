package fa.training.services;

import fa.training.entities.Teacher;
import fa.training.utils.Validator;
import java.util.Date;
import java.util.Scanner;

public class TeacherService {
    private static Scanner scanner = new Scanner(System.in);
    
    public static Teacher inputTeacher() {
        System.out.println("\n=== INPUT TEACHER DATA ===");
        
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
        
        System.out.print("Enter basic salary: ");
        double basicSalary = getDoubleInput();
        
        System.out.print("Enter subsidy: ");
        double subsidy = getDoubleInput();
        
        Teacher teacher = new Teacher(fullName, gender, phone, email, birthDate, basicSalary, subsidy);
        System.out.println("Teacher added successfully!");
        return teacher;
    }
    
    public static void displayTeachersWithHighSalary(Teacher[] teachers, int teacherCount) {
        if (teacherCount == 0) {
            System.out.println("No teachers in the system!");
            return;
        }

        System.out.println("\n=== TEACHERS WITH SALARY > $1000 ===");
        boolean found = false;
        
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i] != null && teachers[i].calculateSalary() > 1000) {
                teachers[i].displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No teachers found with salary > $1000");
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