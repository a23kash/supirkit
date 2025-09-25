// Course class - handles course information
// Still working on the enrollment system

public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private String instructor;
    private String department;
    private int maxStudents;
    private int currentEnrollment;
    private boolean isActive;
    
    // Simple constructor
    public Course(String code, String title, int credits) {
        this.courseCode = code;
        this.title = title;
        this.credits = credits;
        this.instructor = "TBA";
        this.department = "General";
        this.maxStudents = 30;
        this.currentEnrollment = 0;
        this.isActive = true;
    }
    
    // Full constructor
    public Course(String code, String title, int credits, String instructor, String department) {
        this(code, title, credits);
        this.instructor = instructor;
        this.department = department;
    }
    
    // Getters
    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }
    public String getDepartment() { return department; }
    public int getAvailableSlots() { return maxStudents - currentEnrollment; }
    public boolean isActive() { return isActive; }
    
    // Setters
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    public void setMaxStudents(int max) {
        if (max > 0) {
            this.maxStudents = max;
        }
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
    }
    
    // Enrollment management
    public boolean canEnroll() {
        return isActive && currentEnrollment < maxStudents;
    }
    
    public void enrollStudent() {
        if (canEnroll()) {
            currentEnrollment++;
        }
    }
    
    public void unenrollStudent() {
        if (currentEnrollment > 0) {
            currentEnrollment--;
        }
    }
    
    // Display methods
    public void displayInfo() {
        System.out.println("=== Course Information ===");
        System.out.println("Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Credits: " + credits);
        System.out.println("Instructor: " + instructor);
        System.out.println("Department: " + department);
        System.out.println("Enrollment: " + currentEnrollment + "/" + maxStudents);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }
    
    @Override
    public String toString() {
        return courseCode + ": " + title + " (" + credits + " credits)";
    }
    
    public String toDetailedString() {
        return String.format("%s - %s | Instructor: %s | Slots: %d/%d", 
                           courseCode, title, instructor, currentEnrollment, maxStudents);
    }
}
