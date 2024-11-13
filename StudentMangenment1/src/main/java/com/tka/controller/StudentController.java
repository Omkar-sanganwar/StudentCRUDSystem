package com.tka.controller;

import com.tka.entity.Student;
import com.tka.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService;
    private Scanner scanner;

    public StudentController() {
        studentService = new StudentService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    public void handleUserInput() {
        int choice = -1;

        while (choice != 5) {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();
        Student student = new Student(rollNo, name, marks);
        if (studentService.addStudent(student)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    public void viewStudents() {
        List<Student> students = studentService.getAllStudents();
        System.out.println("Roll No | Name | Marks");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent() {
        System.out.print("Enter Roll No of student to update: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Marks: ");
        int marks = scanner.nextInt();
        Student student = new Student(rollNo, name, marks);
        if (studentService.updateStudent(student)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Failed to update student.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter Roll No of student to delete: ");
        int rollNo = scanner.nextInt();
        if (studentService.deleteStudent(rollNo)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Failed to delete student.");
        }
    }
}
