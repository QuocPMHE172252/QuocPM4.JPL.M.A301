package fa.training.main;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.services.StudentService;
import fa.training.services.TeacherService;
import fa.training.utils.Validator;

import java.util.Date;
import java.util.Scanner;

public class PersonManage {
    private static Person[] persons = new Person[10];
    private static int personCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = getIntInput();
            
            switch (choice) {
                case 1:
                    inputData();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    displayTeachersWithHighSalary();
                    break;
                case 4:
                    displayPassingStudents();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== PERSON MANAGEMENT SYSTEM ===");
        System.out.println("1. Input data (create array of 10 persons)");
        System.out.println("2. Update student by student ID");
        System.out.println("3. Display teachers with salary > $1000");
        System.out.println("4. Display passing students (final mark >= 6)");
        System.out.println("5. Exit");
        System.out.println("================================");
    }

    private static void inputData() {
        if (personCount >= 10) {
            System.out.println("Array is full! Cannot add more persons.");
            return;
        }

        System.out.println("\n=== INPUT PERSON DATA ===");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Choose person type: ");
        int type = getIntInput();

        if (type == 1) {
            Student student = StudentService.inputStudent();
            persons[personCount++] = student;
        } else if (type == 2) {
            Teacher teacher = TeacherService.inputTeacher();
            persons[personCount++] = teacher;
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void updateStudent() {
        Student[] students = new Student[10];
        int studentCount = 0;
        
        for (int i = 0; i < personCount; i++) {
            if (persons[i] instanceof Student) {
                students[studentCount++] = (Student) persons[i];
            }
        }
        
        StudentService.updateStudent(students, studentCount);
    }

    private static void displayTeachersWithHighSalary() {
        Teacher[] teachers = new Teacher[10];
        int teacherCount = 0;
        
        for (int i = 0; i < personCount; i++) {
            if (persons[i] instanceof Teacher) {
                teachers[teacherCount++] = (Teacher) persons[i];
            }
        }
        
        TeacherService.displayTeachersWithHighSalary(teachers, teacherCount);
    }

    private static void displayPassingStudents() {
        Student[] students = new Student[10];
        int studentCount = 0;
        
        for (int i = 0; i < personCount; i++) {
            if (persons[i] instanceof Student) {
                students[studentCount++] = (Student) persons[i];
            }
        }
        
        StudentService.displayPassingStudents(students, studentCount);
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
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