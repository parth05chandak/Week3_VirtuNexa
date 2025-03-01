package task1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class DailyLog 
{
    private double caloriesConsumed;
    private double caloriesBurned;

    public DailyLog(double caloriesConsumed, double caloriesBurned) 
    {
        this.caloriesConsumed = caloriesConsumed;
        this.caloriesBurned = caloriesBurned;
    }

    public double getCaloriesConsumed() 
    {
        return caloriesConsumed;
    }

    public double getCaloriesBurned() 
    {
        return caloriesBurned;
    }

    public double netCalories() 
    {
        return caloriesConsumed - caloriesBurned;
    }
}

public class CalorieTracker 
{

    private List<DailyLog> logs;
    private double totalCaloriesConsumed;
    private double totalCaloriesBurned;

    public CalorieTracker() 
    {
        logs = new ArrayList<>();
        totalCaloriesConsumed = 0;
        totalCaloriesBurned = 0;
    }

    public void addLog(double caloriesConsumed, double caloriesBurned) 
    {
        DailyLog log = new DailyLog(caloriesConsumed, caloriesBurned);
        logs.add(log);
        totalCaloriesConsumed += caloriesConsumed;
        totalCaloriesBurned += caloriesBurned;
    }

    public void showSummary() 
    {
        System.out.println("Summary of your daily progress:");
        System.out.println("Total calories consumed: " + totalCaloriesConsumed);
        System.out.println("Total calories burned: " + totalCaloriesBurned);
        System.out.println("Net calories (Consumed - Burned): " + (totalCaloriesConsumed - totalCaloriesBurned));
        System.out.println("Total days logged: " + logs.size());
    }

    public void showDailyLogs() 
    {
        System.out.println("Daily logs:");
        for (int i = 0; i < logs.size(); i++) 
        {
            DailyLog log = logs.get(i);
            System.out.println("Day " + (i + 1) + " - Consumed: " + log.getCaloriesConsumed() + " kcal, Burned: " + log.getCaloriesBurned() + " kcal, Net: " + log.netCalories() + " kcal");
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        CalorieTracker tracker = new CalorieTracker();

        System.out.println("Welcome to the Calorie Tracker!");

        boolean continueLogging = true;

        while (continueLogging) 
        {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Log today's calorie intake and exercise");
            System.out.println("2. View progress summary");
            System.out.println("3. View daily logs");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter calories consumed today: ");
                    double caloriesConsumed = scanner.nextDouble();

                    System.out.print("Enter calories burned through exercise today: ");
                    double caloriesBurned = scanner.nextDouble();

                    tracker.addLog(caloriesConsumed, caloriesBurned);
                    System.out.println("Today's log added successfully.");
                    break;

                case 2:
                    tracker.showSummary();
                    break;

                case 3:
                    tracker.showDailyLogs();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    continueLogging = false;
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}

