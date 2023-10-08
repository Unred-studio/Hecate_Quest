import java.util.Scanner;
import java.util.Random;

public class Trail {
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();
    private static boolean condition;

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        boolean condition;
        do {
            condition = false;
            char userChoice = menu().toUpperCase().charAt(0);
            if (userChoice == 'P') {
                playGame();
            } else if (userChoice == 'S') {
                story();
            } else if (userChoice == 'E') {
                break;
            } else {
                System.out.println("Please enter a valid choice.");
                condition = true;
            }
        } while (condition);
    }

    public static String menu() {
        System.out.println("\nPlay Game [P]");
        System.out.println("Story [S]");
        System.out.println("Exit [E]");
        System.out.print("Your Choice: ");
        String menuChoice = scan.nextLine();
        return menuChoice;
    }

    public static void story() {
        System.out.println("\nYou are the Goddess of Magic, Hecate.");
        System.out.println("One day, you made a mistake while brewing a potion from a poisonous plant.");
        System.out.println("Unfortunately, this potion spread throughout Olympus.");
        System.out.println("All the gods who smelled it became uncontrollable and started to wreak havoc on Earth.");
        System.out.println("It is now your responsibility to protect the Earth by stopping these rogue gods.");
        System.out.println("Your powers are:");
        System.out.println("- Healing (Heal your HP to 100, however your HP shall be below 10)");
        System.out.println("- Elemental Manipulation (Fire, Water, Air, Earth)");
        System.out.println("- Necromancy (Your Best attack but using it also decreases your HP)");
        System.out.println("- Illusion (prevents opponents from attacking)");
        System.out.println("Your main mission is to take on the rogue gods, defeat them using your powers.");
        System.out.println("Good luck, Hecate! The fate of Earth lies in your hands.");

        do {
            condition = false;
            System.out.print("Are you ready to start the game? [Y/N]: ");
            String ready = scan.nextLine();

            if (ready.equalsIgnoreCase("Y")) {
                playGame();
            } else if (ready.equalsIgnoreCase("N")) {
                menu();
            } else {
                System.out.println("Please enter a valid choice.");
                condition = true;
            }
        } while (condition);
    }

    public static void playGame() {
        if (fight("Ares")) {
            if (fight("Artemis")) {
                if (fight("Hades")) {
                    if (fight("Apollo")) {
                        if (!fight("Zeus")) {
                            System.out.println("You have defeated all the gods! You win!");
                        }
                    }
                }
            }
        }
        menu();
    }

    public static boolean fight(String god) {
        int playerHp = 100;
        int opponentHp = 100;
        boolean winner = false;

        while (playerHp > 0 && opponentHp > 0) {
            // Player's turn to attack
            System.out.println("Hecate's Hp: " + playerHp);
            System.out.println(god + " Hp: " + opponentHp);
            opponentHp = playerAttack(playerHp, opponentHp);

            // Check if the opponent's HP has reached 0 or less
            if (opponentHp <= 0) {
                winner = true;
                break;
            }

            // Opponent's turn to attack
            opponentHp = opponentAttack(god, playerHp, opponentHp);

            // Check if the player's HP has reached 0 or less
            if (playerHp <= 0) {
                winner = false;
                break;
            }
        }
        return winner;
    }

    public static int playerAttack(int playerHp, int opponentHp) {
        System.out.println("\nPlease choose your attack:");
        System.out.println("Elemental Manipulation [Fire(F), Water(W), Earth(E), Air(A)]");
        System.out.println("Illusion (I)");
        System.out.println("Necromancy (N)");
        System.out.println("Healing (H)");

        do {
            condition = false;
            System.out.print("Enter your choice: ");
            String attack = scan.nextLine();

            char attackChoice = attack.toUpperCase().charAt(0);

            switch (attackChoice) {
                case 'F':
                case 'W':
                case 'E':
                case 'A':
                    opponentHp = lowAttack(opponentHp);
                    break;
                case 'I':
                    stun();
                    break;
                case 'N':
                    opponentHp = heavyAttack(opponentHp);
                    break;
                case 'H':
                    System.out.println("Hecate restored her HP to 100.");
                    playerHp = heal(playerHp);
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    condition = true;
                    break;
            }
        } while (condition);

        return opponentHp;
    }

    // Implement other attack methods and utility functions here

    // Sample methods for low and heavy attacks
    public static int lowAttack(int opponentHp) {
        opponentHp -= 10;
        return opponentHp;
    }

    public static int heavyAttack(int opponentHp) {
        opponentHp -= 45;
        return opponentHp;
    }

    public static int heal(int initialHp) {
        initialHp = 100;
        return initialHp;
    }

    public static void stun() {
        // Implement stun logic
    }

    public static int opponentAttack(String god, int playerHp, int opponentHp) {
        // Implement opponent attack logic based on the god
        return playerHp; // For now, return player's HP
    }
}

