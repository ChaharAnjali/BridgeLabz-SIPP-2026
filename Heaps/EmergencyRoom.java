package Heaps;

import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class EmergencyRoom {

    // Max Heap based on severity
    static PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    // Add new patient
    static void addPatient(Patient p) {
        triageQueue.offer(p); // O(log n)
    }

    // Treat most severe patient
    static Patient treatNext() {
        return triageQueue.poll(); // O(log n)
    }

    // View most severe patient
    static Patient peekNext() {
        return triageQueue.peek(); // O(1)
    }

    public static void main(String[] args) {

        addPatient(new Patient("Rahul", 5));
        addPatient(new Patient("Anjali", 10));
        addPatient(new Patient("Priya", 7));
        addPatient(new Patient("Amit", 3));

        System.out.println("Next Patient: " + peekNext());

        System.out.println("Treating Patients:");

        while (!triageQueue.isEmpty()) {
            System.out.println(treatNext());
        }
    }
}