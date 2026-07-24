package Queues;

import java.util.PriorityQueue;

public class HospitalERTriage {

    static class Patient {

        int priority;
        String name;

        Patient(int priority, String name) {

            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {

            return name + " (Priority: " + priority + ")";
        }
    }

    static class ERQueue {

        PriorityQueue<Patient> triageQueue;

        ERQueue() {

            // Min-Heap based on priority
            triageQueue = new PriorityQueue<>(
                    (a, b) -> a.priority - b.priority);
        }

        // Add patient
        void admitPatient(Patient patient) {

            triageQueue.offer(patient);
        }

        // Serve most urgent patient
        Patient callNextPatient() {

            if (triageQueue.isEmpty()) {

                throw new RuntimeException(
                        "No patients waiting");
            }

            return triageQueue.poll();
        }

        // View most urgent patient
        Patient peekNextPatient() {

            return triageQueue.peek();
        }
    }

    public static void main(String[] args) {

        ERQueue emergencyRoom = new ERQueue();

        emergencyRoom.admitPatient(
                new Patient(3, "Rahul"));

        emergencyRoom.admitPatient(
                new Patient(1, "Anjali"));

        emergencyRoom.admitPatient(
                new Patient(5, "Amit"));

        emergencyRoom.admitPatient(
                new Patient(2, "Priya"));

        System.out.println(
                "Next Patient: "
                        + emergencyRoom.peekNextPatient());

        System.out.println(
                "Treating: "
                        + emergencyRoom.callNextPatient());

        System.out.println(
                "Treating: "
                        + emergencyRoom.callNextPatient());

        System.out.println(
                "Treating: "
                        + emergencyRoom.callNextPatient());

        System.out.println(
                "Treating: "
                        + emergencyRoom.callNextPatient());
    }
}
