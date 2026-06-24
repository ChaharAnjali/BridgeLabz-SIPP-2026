package Java_Interface;

// package Java_Inheritence;

// Streaming interface
interface StreamingService {

    void streamContent();

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription: Basic Plan");
    }
}

// Gaming interface
interface GamingService {

    void playGame();

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription: Premium Plan");
    }
}

// SmartTV class implementing both interfaces
class SmartTV implements StreamingService, GamingService {

    String[] movies = { "Inception", "Avengers", "Interstellar" };
    String[] games = { "FIFA", "GTA", "Minecraft" };

    @Override
    public void streamContent() {
        System.out.println("Available Movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
    }

    @Override
    public void playGame() {
        System.out.println("\nAvailable Games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }

    // 🔥 Resolve default method conflict
    @Override
    public void showSubscriptionDetails() {
        System.out.println("SmartTV Subscription Details:");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }
}

// Main class
public class SmartTVDemo {
    public static void main(String[] args) {

        SmartTV tv = new SmartTV();

        tv.streamContent();
        tv.playGame();
        tv.showSubscriptionDetails();
    }
}
