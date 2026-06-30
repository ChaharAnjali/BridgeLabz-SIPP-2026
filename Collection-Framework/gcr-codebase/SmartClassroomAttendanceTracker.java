
import java.util.ArrayList;
import java.util.HashMap;

public class SmartClassroomAttendanceTracker {

    // Subject -> List of students present
    HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    // 1. Mark attendance
    public void markAttendance(String subject, String student) {

        // If subject not present, create new list
        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        // 2. Prevent duplicate attendance
        if (students.contains(student)) {
            System.out.println(student + " already marked present in " + subject);
        } else {
            students.add(student);
            System.out.println("Attendance marked: " + student + " -> " + subject);
        }
    }

    // 3. Display attendance
    public void displayAttendance() {
        System.out.println("\n--- Attendance Report ---");

        if (attendance.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);

            System.out.println("\nSubject: " + subject);
            System.out.println("Students Present:");

            for (String s : students) {
                System.out.println("- " + s);
            }

            // 4. Total students per subject
            System.out.println("Total Present: " + students.size());
        }
    }

    // Main method
    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Math", "Anjali");
        tracker.markAttendance("Math", "Rahul");
        tracker.markAttendance("Math", "Neha");

        // Duplicate entry
        tracker.markAttendance("Math", "Rahul");

        tracker.markAttendance("DSA", "Anjali");
        tracker.markAttendance("DSA", "Karan");

        tracker.displayAttendance();
    }
}