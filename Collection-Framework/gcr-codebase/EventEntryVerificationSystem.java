import java.util.HashSet;

public class EventEntryVerificationSystem {

    HashSet<String> participants = new HashSet<>();

    // 1. Register participant
    public void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Registration Successful: " + email);
        } else {
            System.out.println("Duplicate Entry Rejected: " + email);
        }
    }

    // 3. Display all participants
    public void displayParticipants() {
        System.out.println("\n--- Registered Participants ---");

        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {
            for (String email : participants) {
                System.out.println(email);
            }
        }

        // 4. Total count
        System.out.println("Total Attendees: " + participants.size());
    }

    // Main method
    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("anjali@gmail.com");
        event.registerParticipant("rahul@gmail.com");
        event.registerParticipant("neha@gmail.com");

        // Duplicate attempt
        event.registerParticipant("rahul@gmail.com");

        event.displayParticipants();
    }
}