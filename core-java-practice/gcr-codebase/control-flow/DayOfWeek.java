import java.util.Scanner;
 
class DayOfWeek {
    public static void main(String[] args) {
        // Defining the scanner object to take user input
        Scanner input = new Scanner(System.in);

        
        System.out.println("Enter a number between 1 to 7: ");
        int weekDayNumber = input.nextInt();
 
       
        switch (weekDayNumber) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Number");
        }


       
        switch(weekDayNumber) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Weekday");
                break;
            case 7:
            case 1:
                System.out.println("Weekend");
                break;       
        }
        input.close(); 
    }
}
