import java.util.Scanner;
import java.util.ArrayList;

// Main class for Campus Course Manager
// This is my project for the Java course

public class Main {
    
    // Simple lists to store data - using ArrayList for now
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🎓 Welcome to Campus Course Manager!");
        System.out.println("   - My Java University Project -");
        System.out.println();
        
        // Add some sample data for testing
        addSampleData();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageCourses();
                    break;
                case 3:
                    showAllData();
                    break;
                case 4:
                    System.out.println("📁 File operations coming soon...");
                    // TODO: Add file saving/loading
                    break;
                case 0:
                    running = false;
                    System.out.println("👋 Thank you for using Campus Manager!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    // Simple menu display
    private static void showMainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. View All Data");
        System.out.println("4. File Operations");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    
    // Get user input with basic error handling
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }
    
    // Student management - basic version
    private static void manageStudents() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose: ");
        
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                addNewStudent();
                break;
            case 2:
                viewAllStudents();
                break;
            case 3:
                return; // Go back
            default:
                System.out.println("Invalid option!");
        }
    }
    
    // Add a new student - simple version
    private static void addNewStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        
        // Create and add student
        Student newStudent = new Student(id, name, email);
        students.add(newStudent);
        
        System.out.println("✅ Student added successfully!");
        System.out.println("Added: " + newStudent);
    }
    
    // Show all students
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found. Add some students first!");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }
    
    // Course management - basic version
    private static void manageCourses() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add New Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose: ");
        
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                addNewCourse();
                break;
            case 2:
                viewAllCourses();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    // Add a new course
    private static void addNewCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter credits: ");
        int credits = getUserChoice(); // Reusing for simplicity
        
        Course newCourse = new Course(code, title, credits);
        courses.add(newCourse);
        
        System.out.println("✅ Course added successfully!");
    }
    
    // Show all courses
    private static void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found. Add some courses first!");
            return;
        }
        
        System.out.println("\n--- All Courses ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }
    
    // Show all data together
    private static void showAllData() {
        System.out.println("\n=== CURRENT DATA ===");
        System.out.println("Students: " + students.size());
        System.out.println("Courses: " + courses.size());
        
        viewAllStudents();
        viewAllCourses();
    }
    
    // Add some sample data for testing
    private static void addSampleData() {
        // Add sample students
        students.add(new Student("S001", "John Doe", "john@university.edu"));
        students.add(new Student("S002", "Jane Smith", "jane@university.edu"));
        
        // Add sample courses
        courses.add(new Course("CS101", "Introduction to Programming", 3));
        courses.add(new Course("MA201", "Calculus I", 4));
        
        System.out.println("📊 Loaded sample data: 2 students, 2 courses");
    }
}

// Simple Student class - defined in same file for simplicity
class Student {
    private String studentId;
    private String name;
    private String email;
    
    public Student(String id, String name, String email) {
        this.studentId = id;
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return studentId + " - " + name + " (" + email + ")";
    }
}

// Simple Course class
class Course {
    private String courseCode;
    private String title;
    private int credits;
    
    public Course(String code, String title, int credits) {
        this.courseCode = code;
        this.title = title;
        this.credits = credits;
    }
    
    // Getters
    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    
    @Override
    public String toString() {
        return courseCode + ": " + title + " (" + credits + " credits)";
    }

}
