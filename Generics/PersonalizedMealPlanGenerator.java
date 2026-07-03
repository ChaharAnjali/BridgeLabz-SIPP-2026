package Generics;

// Interface
interface MealPlan {
    String getMealType();
}

// Meal Types
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
}

// Generic Class
class Meal<T extends MealPlan> {

    private String userName;
    private T mealPlan;

    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public void displayMeal() {
        System.out.println("User Name : " + userName);
        System.out.println("Meal Plan : " + mealPlan.getMealType());
        System.out.println();
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Main Class
public class PersonalizedMealPlanGenerator {

    // Generic Method
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Meal Plan Generated Successfully!");
        meal.displayMeal();
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> meal1 = new Meal<>("Anjali", new VegetarianMeal());

        Meal<VeganMeal> meal2 = new Meal<>("Rahul", new VeganMeal());

        Meal<KetoMeal> meal3 = new Meal<>("Priya", new KetoMeal());

        Meal<HighProteinMeal> meal4 = new Meal<>("Aman", new HighProteinMeal());

        generateMealPlan(meal1);
        generateMealPlan(meal2);
        generateMealPlan(meal3);
        generateMealPlan(meal4);
    }
}