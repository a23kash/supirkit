import java.util.ArrayList;
import java.util.List;

// Student class for the campus management system
// This handles basic student information and course enrollment
// I might need to add more fields later for the grade system

public class Student {
    // Basic student info - using simple fields for now
    private String studentId;
    private String name;
    private String email;
    private String department;
    private boolean isActive;
    
    // For tracking courses - using ArrayList because it's flexible
    private List<String> enrolledCourses;
    
    // Constructor - simple version
    public Student(String id, String name, String email) {
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.department = "General"; // default department
        this.isActive = true;
        this.enrolledCourses = new ArrayList<>();
        
        System.out.println("New student created: " + name);
    }
    
    // Another constructor with department
    public Student(String id, String name, String email, String department) {
        this(id, name, email);
        this.department = department;
    }
    
    // Getters - basic ones
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Setters - with some basic validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Invalid name provided");
        }
    }
    
    public void setEmail(String email) {
        // Basic email check - could be better
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email should contain @ symbol");
        }
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
        System.out.println("Student " + name + " is now " + (active ? "active" : "inactive"));
    }
    
    // Course enrollment methods
    public void enrollInCourse(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            System.out.println("Invalid course code");
            return;
        }
        
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
            System.out.println(name + " enrolled in " + courseCode);
        } else {
            System.out.println(name + " is already enrolled in " + courseCode);
        }
    }
    
    public void unenrollFromCourse(String courseCode) {
        if (enrolledCourses.contains(courseCode)) {
            enrolledCourses.remove(courseCode);
            System.out.println(name + " unenrolled from " + courseCode);
        } else {
            System.out.println(name + " is not enrolled in " + courseCode);
        }
    }
    
    public List<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses); // Return copy for safety
    }
    
    public int getCourseCount() {
        return enrolledCourses.size();
    }
    
    // Display methods
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Courses enrolled: " + enrolledCourses.size());
    }
    
    public void displayCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses");
            return;
        }
        
        System.out.println("Courses enrolled by " + name + ":");
        for (int i = 0; i < enrolledCourses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + enrolledCourses.get(i));
        }
    }
    
    // toString method for easy printing
    @Override
    public String toString() {
        return studentId + " - " + name + " (" + email + ")";
    }
    
    // Quick info for lists
    public String toShortString() {
        return name + " (" + studentId + ")";
    }
    
    // Helper method to check if enrolled in specific course
    public boolean isEnrolledIn(String courseCode) {
        return enrolledCourses.contains(courseCode);
    }
    
    // TODO: Add grade tracking later
    // TODO: Add semester information
    // TODO: Improve email validation
}
