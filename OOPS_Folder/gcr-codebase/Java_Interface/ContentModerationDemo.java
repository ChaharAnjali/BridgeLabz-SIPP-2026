package Java_Interface;

// Interface 1
interface TextModeration {

    boolean checkText(String post);

    default void displayModerationPolicy() {
        System.out.println("Text Policy: No offensive language allowed.");
    }
}

// Interface 2
interface SpamDetection {

    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam Policy: No repeated or promotional spam allowed.");
    }
}

// Class implementing both interfaces
class ContentModerator implements TextModeration, SpamDetection {

    // Sample restricted words list
    static String[] restrictedWords = { "badword", "hate", "abuse" };

    // Static method
    public static boolean containsRestrictedWords(String post) {
        for (String word : restrictedWords) {
            if (post.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    // Check offensive content
    @Override
    public boolean checkText(String post) {
        return containsRestrictedWords(post);
    }

    // Check spam content (simple logic)
    @Override
    public boolean isSpam(String post) {
        // spam if repeated words or very long promotional text
        return post.length() > 50 || post.toLowerCase().contains("buy now");
    }

    // Resolve default method conflict
    public void displayModerationPolicy() {
        System.out.println("=== Moderation Policy ===");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    // Process posts
    void moderatePosts(String[] posts) {

        for (String post : posts) {

            System.out.println("\nPost: " + post);

            if (checkText(post)) {
                System.out.println("Status: OFFENSIVE ");
            } else if (isSpam(post)) {
                System.out.println("Status: SPAM ");
            } else {
                System.out.println("Status: VALID ");
            }
        }
    }
}

// Main class
public class ContentModerationDemo {
    public static void main(String[] args) {

        String[] posts = {
                "I love Java programming",
                "buy now cheap products buy now",
                "this contains badword content",
                "Hello everyone, good morning!"
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();
        moderator.moderatePosts(posts);
    }
}
