import java.util.Scanner;
public class DengueEscapeSurvivalGame {
    public static void main(String[] args) {
        int health = 100;
        int daysSurvived = 0;
        int food = 0;
        int repellent = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("🦟 Dengue Escape Survival Game");
        System.out.println("Survive for 10 days without your health reaching 0!\n");

        while (daysSurvived < 10 && health > 0) {
            System.out.println("Day " + (daysSurvived + 1));
            System.out.println("Health: " + health + " | Food: " + food + " | Repellent: " + repellent);
            System.out.println("Choose an action:");
            System.out.println("1. Stay Indoors (health -5)");
            System.out.println("2. Go Outside for Supplies (health -15, gain 1 food & 1 repellent)");
            System.out.println("3. Apply Repellent (use 1 bottle)");
            System.out.println("4. Rest (health +10)");
            System.out.println("5. Cook and Eat Food (health +15, use 1 food)");
            System.out.println("6. Help a Neighbour (health -5, gain 1 food & 1 repellent)");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Stay indoors
                    health -= 5;
                    System.out.println("You stayed indoors and avoided danger but lost 5 health from stress.");
                    daysSurvived++;
                    break;

                case 2: // Go outside
                    health -= 15;
                    food++;
                    repellent++;
                    System.out.println("You went outside, lost 15 health, but found 1 food and 1 repellent.");
                    daysSurvived++;
                    break;

                case 3: // Apply repellent
                    if (repellent > 0) {
                        repellent--;
                        System.out.println("You applied repellent for the day.");
                    } else {
                        System.out.println("No repellent left!");
                    }
                    daysSurvived++;
                    break;

                case 4: // Rest
                    health = Math.min(100, health + 10);
                    System.out.println("You rested and regained 10 health.");
                    daysSurvived++;
                    break;

                case 5: // Eat food
                    if (food > 0) {
                        food--;
                        health = Math.min(100, health + 15);
                        System.out.println("You ate a meal and regained 15 health.");
                    } else {
                        System.out.println("No food to eat!");
                    }
                    daysSurvived++;
                    break;

                case 6: // Help neighbour
                    health -= 5;
                    food++;
                    repellent++;
                    System.out.println("You helped a neighbour, lost 5 health, but gained 1 food and 1 repellent.");
                    daysSurvived++;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

            System.out.println();
        }

        if (health <= 0) {
            System.out.println("💀 Health reached 0. You got infected… Game Over.");
        } else {
            System.out.println("🎉 You survived 10 days! You escaped the dengue outbreak!");
        }

        sc.close();
    }
}
